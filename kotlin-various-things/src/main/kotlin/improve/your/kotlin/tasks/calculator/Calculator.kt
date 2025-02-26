package improve.your.kotlin.tasks.calculator

import java.math.BigDecimal


interface Calculator {
    fun plus(vararg numbers: Double): Double
    fun minus(vararg numbers: Double): Double
    fun times(vararg numbers: Double): Double
    fun div(vararg numbers: Double): Double
}

class CalculatorImpl : Calculator {
    override fun plus(vararg numbers: Double): Double {
        var result : Double = 0.0
        for(number in numbers) {
            result+=number
        }
        return result
    }

    override fun minus(vararg numbers: Double): Double {
        var result : BigDecimal = numbers.first().toBigDecimal()
        for(number in 1..numbers.lastIndex) {
            result -= numbers[number].toBigDecimal()
        }
        return result.toDouble()
    }

    override fun times(vararg numbers: Double): Double {
        var result : Double = 0.0
        for(number in numbers) {
            result*=number
        }
        return result
    }

    override fun div(vararg numbers: Double): Double {
        var result : BigDecimal = numbers.first().toBigDecimal()
        for(number in 1..numbers.lastIndex) {
            if(numbers[number] != 0.0) {
                result /= numbers[number].toBigDecimal()
            } else {
                throw Exception("на ноль делить нельзя")
            }
        }
        return result.toDouble()
    }
}

fun main() {
    val result = CalculatorImpl().plus(1.0, 2.0, 3.0 )
    println(result)
}