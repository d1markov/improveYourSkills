package improve.your.kotlin.nullSafety

import java.lang.Exception

/** Система типов Kotlin различает ссылки на те, которые могут иметь значение null (nullable ссылки) и те, которые таковыми быть не могут (non-null ссылки)
 *
 */

fun main() {
    checkNN1("borshch")
    checkNN1(null)

    checkNN2("shchi")
    checkNN2(null)

    checkNN3("shchaveliviy")
    checkNN3(null)

    checkNN4("beetrootnick")
    checkNN4(null)

    checkNN5("kyriniy")
    checkNN5(null)
}

//simple check like java
fun checkNN1(course: String?) {
    if (course != null) println("course added : $course") else println("course not added")
}

//elvis operator
fun checkNN2(course: String?) {
    course.apply { println("course added : $this") } ?: println("course not added")
}

// do something if it not null
fun checkNN3(course: String?) {
    course?.let { println("course added : $it") }
}

//check and trow  error "Required value was null"
fun checkNN4(course: String?) {
    try {
        checkNotNull(course)
        println("course added : $course")
    } catch (e: Exception) {
        println("\n${e.message}\n")
    }

}

//check and trow null pointer
fun checkNN5(course: String?) {
    try {
        println("course added : ${course!!}")
    } catch (e: NullPointerException) {
        println("NullPointerException!")
    }
}