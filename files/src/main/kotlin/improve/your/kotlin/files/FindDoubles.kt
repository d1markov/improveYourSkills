package improve.your.kotlin.files

import java.io.File

fun main() {
    val dir =
        File("/Users/d.markov/Desktop/workFolder/dev/script/links.txt")
    val lines = dir.readLines()
    val doubles = mutableListOf<String>()
    lines.forEach { line ->
        if(line.isNotBlank()) {
            val ids = line.split(":")
            if (lines.count { it.contains(ids[1]) } > 1) {
                doubles.add(line)
            }
        }

    }
    File("/Users/d.markov/Desktop/workFolder/dev/script/doubles.txt").writeText(doubles.joinToString("\n"))

}