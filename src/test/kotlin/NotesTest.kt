import org.junit.Test

import org.junit.Assert.*

class NotesTest {

    @Test
    fun add() {
        val note1 = Note(title = "Title 1", content = "New content")
        val notes = Notes

        notes.add(note1)
        assertTrue(notes.getCountNote() != 1)
    }

    @Test
    fun editTrue() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val newNote = Note(title = "New title", content = "New content")

        notes.add(note1)
        assertTrue(notes.edit(1, newNote))
    }

    @Test(expected = NoteNotFoundException::class)
    fun edit() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val newNote = Note(title = "New title", content = "New content")

        notes.add(note1)
        assertTrue(notes.edit(0, newNote))
    }

    @Test
    fun deleteTrue() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")

        notes.add(note1)
        assertTrue(notes.delete(1))
    }

    @Test(expected = NoteNotFoundException::class)
    fun delete() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")

        notes.add(note1)
        assertTrue(notes.delete(100))
    }

    @Test
    fun addCommentTrue() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(1, comment)
        assertTrue(notes.getCountCom() != 0)
    }

    @Test(expected = NoteNotFoundException::class)
    fun addComment() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(100, comment)
        assertTrue(notes.getCountCom() == 1)
    }

    @Test
    fun editCommentTrue() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(1, comment)
        assertTrue(notes.editComment(3, "New comment"))
    }

    @Test(expected = NoteNotFoundException::class)
    fun editComment() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(1, comment)
        assertTrue(notes.editComment(0, "New comment"))
    }

    @Test
    fun deleteCommentTrue() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(1, comment)
        assertTrue(notes.deleteComment(1))
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteComment() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(1, comment)
        assertTrue(notes.deleteComment(0))
    }

    @Test
    fun restoreCommentTrue() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(12, comment)
        notes.deleteComment(5)
        assertTrue(notes.restoreComment(1))
    }

    @Test(expected = NoteNotFoundException::class)
    fun restoreComment() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New content")
        val comment = Comment(content = "Comment")

        notes.add(note1)
        notes.addComment(12, comment)
        notes.deleteComment(6)
        assertTrue(notes.restoreComment(0))
    }

    @Test
    fun getByIdTrue() {
        val notes = Notes
        var note1 = Note(title = "Title 1", content = "New")

        notes.add(note1)
        note1 = note1.copy(id=6)
        val note2 = notes.getById(6)
        assertTrue(note1 == note2)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getById() {
        val notes = Notes
        val note1 = Note(title = "Title 1", content = "New")

        notes.add(note1)
        val note2 = notes.getById(0)
        assertTrue(note1 == note2)
    }
}