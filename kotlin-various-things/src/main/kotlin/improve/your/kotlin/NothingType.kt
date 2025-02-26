package improve.your.kotlin

/** Что за тип данных Nothing, зачем он нужен
 * Nothing — класс, который является наследником любого класса в Kotlin, даже класса с модификатором final
 * Так как невозможно передать или вернуть тип Nothing, он описывает результат «функции, которая никогда ничего не вернёт»
 * Например функция fail в библиотеках тестирования или функция с бесконечным циклом.
 */

fun fail(message: String): Nothing = throw NotImplementedError(message)

fun main() {
    val address: String? = null
    val destination = address ?: fail("no address")
}