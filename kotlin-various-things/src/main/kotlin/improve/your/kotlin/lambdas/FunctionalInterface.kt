package improve.your.kotlin.lambdas


fun main() {
    // первый вариант
    val rm = RandomMultiply { number ->
        val randomNumber = Math.random()
        println("randomNumber is $randomNumber")
        number * randomNumber
    }
    rm.multiply(7)

    // второй
    printRand { number ->
        val randomNumber = Math.random()
        println("randomNumber is $randomNumber")
        number * randomNumber
    }

}

fun interface RandomMultiply {
    fun multiply(i: Int): Double
}

fun printRand(lambda: RandomMultiply) {
    println("result is ${lambda.multiply(7)}")
}