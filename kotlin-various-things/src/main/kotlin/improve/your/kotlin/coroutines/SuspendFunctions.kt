package improve.your.kotlin.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/**
 * suspend functions
 * Они используются с сочетании например с kotlinx.coroutines
 * Их выполнение может быть остановлено сопрограммой, например для ожидания готовности результата.
 */

fun main() {
    runBlocking {

        println("execute without async:")
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            println("The answer is ${one + two}")
        }
        println("Completed in $time ms")

        println("------------")

        println("execute with async:")
        asyncCall()
    }
    //asyncCall() error Suspend function 'asyncCall' should be called only from a coroutine or another suspend function
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // притворимся, что мы делаем что-то полезное здесь
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // притворимся, что мы тоже делаем что-то полезное здесь
    return 29
}

suspend fun asyncCall() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}


