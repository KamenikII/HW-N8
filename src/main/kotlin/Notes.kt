import java.sql.DriverManager.println

object Notes {
    private var notes = emptyArray<Note>() //A
    private var maxNoteId = 0 //B
    private var comments = emptyArray<Comment>() //A
    private var maxComId = 0 //B


    //TODO work with note
    fun add(note: Note): Note { //Создаёт заметку
        maxNoteId += 1
        notes += note.copy(id = maxNoteId)
        return notes.last()
    }


    fun edit( //редактировать заметку
        id: Int, note: Note //id поста, который меняем, note - содержит заметку с изменениями
    ): Boolean { //при успехе возращает true
        for ((index, n) in notes.withIndex()) {
            if (n.id == id && !n.del) {
                notes[index] = n.copy(
                    title = note.title, content = note.content,
                    privacy = note.privacy, commentPrivacy = note.commentPrivacy
                )
                return true
            }
        }
        throw NoteNotFoundException("No note with ID $id")
    }

    fun delete( //удалять заметку
        id: Int //note id
    ): Boolean { //при успехе возращает true
        for ((index, n) in notes.withIndex()) {
            if (n.id == id && !n.del) {
                notes[index] = n.copy(del = true)
                return true
            }
        }
        throw NoteNotFoundException("No note with ID $id")
    }

    //TODO
    fun getNotes() {//Возращает список заметок
        for ((index, n) in notes.withIndex()) {
            println(" $n.title \n n.content \n ***===*** \n\n")
        }
    }

    fun getById( //Возращает заметку по id
        id: Int //note ID
    ): Note {
        for ((index, note) in notes.withIndex()) {
            if (note.id == id && !note.del) return note
        }
        throw NoteNotFoundException("No note with ID $id")
    }

    //TODO work with comments
    fun addComment( //Создать коммент
        noteId: Int, //note ID
        comment: Comment
    ): Comment {
        for ((index, note) in notes.withIndex()) {
            if (note.id == noteId && !note.del) {
                maxComId += 1
                comments += comment.copy(id = maxComId, noteId = noteId)
                return comments.last()
            }
        }
        throw NoteNotFoundException("No note with ID $noteId")
    }

    fun editComment( //Изменить коммент
        id: Int, //comment ID
        content: String //comment text
    ): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.id == id && !comment.del) {
                comments[index] = comment.copy(content = content)
                return true
            }
        }
        throw NoteNotFoundException("No comment with ID $id")
    }

    fun deleteComment( //Удалить коммент
        id: Int //comment ID
    ): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.id == id && !comment.del) {
                comments[index] = comment.copy(del = true)
                return true
            }
        }
        throw NoteNotFoundException("No comment with ID $id")
    }

    //TODO
    fun getComments( //возращает список комментов заметки
        noteId: Int //note ID
    ) {
        for ((index, comment) in comments.withIndex()) {
            if (comment.noteId == noteId && !comment.del) {
                println(" ${comment.content} \n ***===*** \n\n")
            }
        }
        throw NoteNotFoundException("No note with ID $noteId")
    }

    fun restoreComment( //Восстанавливает удалённый комментарий
        id: Int //comment ID
    ): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.id == id && comment.del) {
                comments[index] = comment.copy(del = false)
                return true
            }
        }
        throw NoteNotFoundException("No comment with ID $id")
    }

    fun getCountNote(): Int {
        return notes.size
    }

    fun getCountCom(): Int {
        return comments.size
    }
}


//TODO ERRORS
class NoteNotFoundException(message: String) : RuntimeException(message)

