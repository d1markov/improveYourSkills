package improve.your.kotlin.files

import java.io.File

/** для импакта
 *  добавляет коммент во все тесты
 */
fun main() {
    val dir =
        File("/Users/d.markov/StudioProjects/mvno-android-features/demo/src/androidTest/java/ru/tinkoff/mvno_features")
    var editedFilesCounter = 0
    var annotationCounter = 0
    val funRegexp = Regex("fun `(\\d+)(?:_\\d+)*`")
    dir.walk().forEach { file ->
        if (file.extension == "kt") {
            val lines = file.readLines().toMutableList()
            var isAllureIdAdded = false
            var nextlineIndex = 0
            lines.forEachIndexed { index, line ->
                if (line.contains(funRegexp) && lines[index - 1].contains("//").not()) {
                    if (lines[index - 1].contains("AllureId") || lines[index - 1].contains("@Test")) {
                        nextlineIndex = index + 1
                        lines[nextlineIndex] = "    // change for all tests \n${lines[nextlineIndex]}"
                        annotationCounter += 1
                    }
                }
            }
            // File("/Users/d.markov/Desktop/20344/grepProjectFiles/classesWithoutAllureId/output.txt").writeText(lines.joinToString("\n"))
            lines[lines.lastIndex] += "\n"
            file.writeText(lines.joinToString("\n"))
        }
    }
    println("annotationCounter $annotationCounter")

}



