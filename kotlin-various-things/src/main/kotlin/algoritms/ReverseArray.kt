package algoritms

// Задача с собеса
// Дано: массив с числами
// Написать reverse, без доп массивов, менять можно только текущий
// Без встроенных функций


fun main() {
    val numbers = arrayOf(2, 3, 7, 9, 5)
    var tempNumber = 0
    var inverseIndex = 0
    numbers.forEach { println(it) }

    for (index in numbers.indices) {
        inverseIndex = numbers.lastIndex - index
        tempNumber = numbers[inverseIndex]
        numbers[inverseIndex] = numbers[index]
        numbers[index] = tempNumber
        if (index == numbers.size / 2) {
            break
        }
    }
    val pixel = arrayOf(intArrayOf()).getPixel(0,0)
    println("reversed")
    numbers.forEach { println(it) }
}

data class Pixel(
    val row: Int,
    val column: Int,
    val color: Int
)

fun Array<IntArray>.getPixel(row: Int, column: Int): Pixel? =
    if (row in this.indices && column in this[0].indices) {
        Pixel(row, column, this[row][column])
    } else {
        null
    }