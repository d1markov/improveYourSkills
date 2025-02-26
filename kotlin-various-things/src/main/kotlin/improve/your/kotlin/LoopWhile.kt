package improve.your.kotlin

fun main() {
    val numbers = listOf(1,2,3,4,5,6)
    var current = 0
    var i = 0
    while(current < 5) {
        println("i=$i")
        current = numbers[i]
        println(current)
        i++
    }
    val newList = mutableListOf<Int>()
    newList.addAll(listOf<Int>())
    newList.addAll(numbers)
    newList.forEach{ it->
        println("it is $it")

    }

}