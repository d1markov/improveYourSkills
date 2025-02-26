package testsFinder

import java.io.File

fun main() {
    val tests = ChangedTestsFinder().find(targetBranch = "test/MVNO-22140-1-deleted-file-1-changed-classname")
    if (tests.isEmpty()) {
        println("its empty")
    } else {
        tests.forEach {
            println(it)
        }
    }
}