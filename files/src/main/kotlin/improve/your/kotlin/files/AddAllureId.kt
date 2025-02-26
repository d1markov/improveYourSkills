package improve.your.kotlin.files

import java.io.File

/** Изменяет все файлы с расширением .kt в указанной директории. Добавляет анотацию @AllureId("id"), id берет из имени метода
 * Добавляет import если хотябы один AllureId добавлен
 */
fun main() {
    val dir =
        File("/Users/d.markov/StudioProjects/mvno-android-features/demo/src/androidTest/java/ru/tinkoff/mvno_features")
    var editedFilesCounter = 0
    val funRegexp = Regex("fun `(\\d+)(?:_\\d+)*`")
    dir.walk().forEach { file ->
        if (file.extension == "kt") {
            val lines = file.readLines().toMutableList()
            var isAllureIdAdded = false
            var annotationCounter = 0
            lines.forEachIndexed { index, line ->
                if (line.contains(funRegexp) && lines[index - 1].contains("@Test") && lines[index - 1].contains("//").not()) {
                    val methodName = line.substringAfter("`").substringBefore("`")
                    val allureID = if (methodName.contains("_")) methodName.substringBefore("_") else methodName
                    //lines.add(index, """@AllureID("$allureID")""")
                    lines[index] = "\t@AllureId(\"$allureID\")\n$line"
                    if (annotationCounter < 1) isAllureIdAdded = true
                    annotationCounter += 1
                }
            }
            val allureIdImport = "import io.qameta.allure.kotlin.AllureId"
            if (isAllureIdAdded && lines.contains(allureIdImport).not()) {
                val lastLineWithImport = lines.indexOfLast { it.contains("import") }
                //TODO если проходить по второму кругу то есть доставлять айдишники в новых тестах надо чекнуть не задублируется ли import
                //TODO исключить закоменченные тесты
                lines.add(lastLineWithImport + 1, allureIdImport)
                editedFilesCounter += 1
            }

            // File("/Users/d.markov/Desktop/20344/grepProjectFiles/classesWithoutAllureId/output.txt").writeText(lines.joinToString("\n"))
            lines[lines.lastIndex] += "\n"
            file.writeText(lines.joinToString("\n"))
        }
    }
    println("editedFilesCounter $editedFilesCounter")

}



