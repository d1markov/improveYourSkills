package improve.your.kotlin.lambdas

fun foo(): () -> String {
    return { "Hello, World!" }
}

fun foo(x: Int): (Int) -> Int {
    return { y -> x + y }
}

fun main() {
    val strings = foo()()
    println(strings)  // Выведет: "Hello, World!"

    val numbers = foo(10)(20)
    println(numbers)  // Выведет: 30
}