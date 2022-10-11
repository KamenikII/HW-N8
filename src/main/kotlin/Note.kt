data class Note (
    val id: Int = -1, //note ID, -1 - не сущ. id
    var title: String,  //title of note
    var content: String, //text of note
    var privacy: Int = 0, //who can work with note
    //[0 - all, 1 - friends only, 2 - friends and friends of friends only, 3 - only you]
    var commentPrivacy: Int = 0, //who can comment note
    //[0 - all, 1 - friends only, 2 - friends and friends of friends only, 3 - only you]
    val del: Boolean = false //this comment deleted or not
)

data class Comment (
    val noteId: Int = -1, //note ID
    val id: Int = -1, //comment ID
    val content: String, //comment text
    val del: Boolean = false //this comment deleted or not
)

//object Comments {
//    private var comments = emptyArray<Comment>()
//
//    fun addComment(comment: Comment): Comment {
//        comments += comment.copy()
//        return comments.last()
//    }
//}

