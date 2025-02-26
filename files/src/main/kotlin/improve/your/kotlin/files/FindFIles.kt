import java.io.File

fun main() {
    val kmmDir =
        File("/Users/d.markov/StudioProjects/mvno-kmm/app/src/androidTest")
    val mapping = File("/Users/d.markov/Desktop/workFolder/dev/script/links.txt").readLines()
    val testsInProject = mutableListOf<String>()
    var count=0
    mapping.forEach { line ->
        if(line.isNotBlank()) {
            val ids = line.split(":")
            kmmDir.walk().forEach { file ->
                if (file.extension == "kt") {
                    file.readLines().forEach{
                        if(it.contains("fun C${ids.last()}")) {
                            testsInProject.add(line)
                            count++
                        }
                    }
                }
            }
        }
    }
    println(count)
    File("/Users/d.markov/Desktop/workFolder/dev/script/testsInProject.txt").writeText(testsInProject.joinToString("\n"))
}