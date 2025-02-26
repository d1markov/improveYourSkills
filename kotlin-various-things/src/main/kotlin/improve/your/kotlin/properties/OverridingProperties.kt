package improve.your.kotlin.properties

/** Переопределение полей
 * Как переопределить поле?
* Можно ли переопределять val поле в var?А наоборот?
 * В клааах мспользовать модификатор open
 * Можно, а вот var в val нельзя
 * https://kotlinlang.ru/docs/inheritance.html#overriding-properties
 */

open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    override val vertexCount = 4
}

class Circle : Shape() {
    override var vertexCount = 0
}

interface Shape2 {
    val vertexCount: Int
}

class Rectangle2(override val vertexCount: Int = 4) : Shape2 // Всегда имеет 4 вершины

class Polygon : Shape2 {
    override var vertexCount: Int = 0  // Может быть установлено любое количество
}