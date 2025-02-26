package improve.your.kotlin.strings

fun main() {
    val text = listOf("one line", "line two", "line three")
    val string = buildString {
        appendLine(text.joinToString(appendLine()))
        appendLine("OR")
        text.forEach { line ->
            appendLine(line)
        }
    }
    println(string)

}