package improve.your.kotlin.properties

/** Что такое getter и setter и зачем они нужны, применительно к Kotlin
 * Getter - метод, который вызывается при каждом обращении к переменной.
 * Setter - метод, который вызывается при каждом присвоении значения переменной.
 *
 */

class GettersSetters {

    private val width = 1
    private val height = 2

    val area get() = this.width * this.height


    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            value.uppercase()
        }

}

fun main() {

}