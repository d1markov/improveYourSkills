package improve.your.kotlin

fun main(args: Array<String>) {

    //difference between fold and reduce is:
    // fold use "initial" argument as first value of  sum
    // reduce use first  and second elements as arguments

    val listOfNumbers = listOf(2, 1, 1, 1)
    val sequenceOfNumbers = listOfNumbers.asSequence()
    var i = 0

    val reducedList = listOfNumbers.reduce { sum, element ->
        i++
        println("step${i}")
        sum + element
    }

    println("reducedList compared to $reducedList")

    i = 0
    val foldedList = sequenceOfNumbers.fold(0) { sum, element ->
        i++
        println("step${i}")
        sum + element
    }

    println("foldedList compared to $foldedList")


    println("it's for \n")
    var sum = 0
    for(n in listOfNumbers) {
        sum += n

    }
    println("sum after for: $sum")

}