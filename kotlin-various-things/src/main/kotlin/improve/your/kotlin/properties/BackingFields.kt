package improve.your.kotlin.properties

/** Что такое Backing fields. При каких условиях создаются. Ключевое слово для обращения
 * Это поле, которое будет сгенерировано для параметра класса.
 * Поле будет создано если параметр использует хотя бы один дефолтный метод доступа. Ключевое слово field.
 * Идентификатор field может быть использован только в методах доступа к свойству.

 * https://kotlinlang.org/docs/properties.html#backing-fields
 *
 */


//Например нам нужно написать сеттер который примет значение которое больше нуля.
//В случае с counter0 он будет переорпеделяться бесконечно.
var counter0 = 0
    set(value) {
        if (value > 0)
            counter0 = value
    }

//чтобы этого избежать нужно использовать ключевое слово field:
var counter = 0 // инициализатор назначает резервное поле напрямую
    set(value) {
        if (value > 0)
            field = value // значение при инициализации записывается
        // прямиком в backing field

        // counter = value // ERROR StackOverflow: Использование 'counter' сделало бы сеттер рекурсивным
    }

fun main() {
    counter = 10
    println(counter)
}