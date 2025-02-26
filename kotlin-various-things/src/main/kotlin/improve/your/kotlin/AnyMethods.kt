package improve.your.kotlin

/**
 * Какие методы есть у класса Any
 * Что за тип данных Any, зачем он нужен
 * Класс Any содержит всего 3 метода
 *
 * Any — это аналог Object в Java
 * содержит методы equals, hashCode, toString
 * Остальные методы класса object добавляются при компиляции в java
 */

class AnyMethods: Any() {

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

}