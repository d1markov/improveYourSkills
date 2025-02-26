package improve.your.kotlin.nullSafety

fun main() {
    withLet(1)
    withLet(null)
}

fun withLet(num: Int?) {
    num?.let {
        println("with let:")
        println("num is $it\n")
    }

    println("without let:")
    println("num is $num\n")

}