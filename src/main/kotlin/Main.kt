//open class NoCom<A, B, C>(var max: A, var array: B, var delArray: B, var thing: C) {
//    fun add(thing: C): C {
//        max += 1
//        array += thing.copy(id = max)
//        return array.last()
//    }
//
//    fun edit(id: Int, thing: C): Boolean {
//        for ((index, n) in array.withIndex()) {
//            if (thing.id == id) {
//                array[index] = thing.copy()
//                return true
//            }
//        }
//        throw NotFoundException("No note with ID $id")
//    }
//
//    fun delete(id: Int): Boolean {
//        for ((index, n) in array.withIndex()) {
//            if (thing.id == id) {
//                delArray += n
//                array.remove[index]
//                return true
//            }
//        }
//        throw NotFoundException("No note with ID $id")
//    }
//
//    fun restore(id: Int): Boolean {
//        for ((index, comment) in delArray.withIndex()) {
//            if (comment.id == id) {
//                array += comment.copy()
//                delArray.remove[index]
//                return true
//            }
//        }
//        throw NotFoundException("No comment with ID $id")
//    }
//}
//
//class NotFoundException(message: String) : RuntimeException(message)