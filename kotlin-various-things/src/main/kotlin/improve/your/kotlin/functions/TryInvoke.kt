package improve.your.kotlin.functions

fun main() {
    invokeSmth {
        println("вызов функции полученной из аргумента")
    }

    val hello = Greeter("Hello")
    hello("world")
}

fun invokeSmth(action: () -> Unit) {
    action()
    action.invoke()
}

class Greeter(val greeting: String) {
    operator fun invoke(target: String) = println("$greeting $target!")
}
