package improve.your.kotlin.files

import java.io.File

fun main() {
    val testsInProject = File("/Users/d.markov/Desktop/workFolder/dev/script/testsInProject.txt").readLines()
    val automatedLines = File("/Users/d.markov/Desktop/workFolder/dev/script/realDoubles_automated.txt").readLines()
    var testsWithoutDoubles : List<String>
    testsWithoutDoubles = testsInProject.filter { !automatedLines.contains(it) }
    automatedLines.forEach { line ->
        if(line.isNotBlank()) {
            val ids = line.split(":")
            testsWithoutDoubles = testsWithoutDoubles.filter { !it.contains(ids[1]) }.toMutableList()
        }
    }
    testsWithoutDoubles = testsWithoutDoubles + automatedLines




    /*testsInProject.forEach { line ->
        if(line.isNotBlank()) {
            val ids = line.split(":")
            automatedLines.find { it.contains(line) && it.contains(ids.last()) }
            if(!automatedLines.contains(line) && automatedLines.contains(ids.last())) {
                testsInProject.remove(line)
            }
        }
    }*/
    File("/Users/d.markov/Desktop/workFolder/dev/script/testsInProject_withoutDoubles.txt").writeText(testsWithoutDoubles.joinToString("\n"))
}