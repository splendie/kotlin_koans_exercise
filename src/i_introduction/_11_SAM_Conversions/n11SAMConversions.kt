package i_introduction._11_SAM_Conversions

import util.TODO
import util.doc11
import java.util.*

fun todoTask11(): Nothing = TODO(
        """
        Task 11.
        When an object implements a SAM interface (one with a Single Abstract Method), you can pass a lambda instead.
        Rewrite the previous example changing an object expression to a lambda.
    """,
        documentation = doc11()
)

fun task11(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, { x, y -> compare(x, y) })
    return arrayList
}

fun compare(x: Int, y: Int): Int =
        if (x < y) 1 else if (x == y) 0 else -1