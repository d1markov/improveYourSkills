package improve.your.kotlin

/** Задача на StackOverflow
 * Что произойдет при обращении к следующей переменной
 * var firstName : String
 * get() = firstName
 * set(value) {firstName = value}
 *
 * получим StackOverflow
 * Достаточно, если увидит, что могут быть проблемы
 */

var firstName: String
    get() = firstName
    set(value) {
        firstName = value
    }

fun main() {
    println(firstName)
}