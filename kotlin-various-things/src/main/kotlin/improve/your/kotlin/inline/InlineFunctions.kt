package improve.your.kotlin.inline

/**
 * Зачем нужны inline функции
 * Коротко - для улучшения производительности
 *
 * Моя проработка:
 * суть в том, что если написать inline перед функцией то, она будет встроена в место вызова во время компиляции,
 * а если этого не сделать будет создано по обьекту на каждый вызов функции.
 * Что является накладным для производительность т.к. обеъкты весят больше чем встраиваемый код.
 * На практике это можно увидеть если в idea перейти в tools -> kotlin -> show kotlin byteCode -> Decompile
 */

inline fun <T> go(with: String, where: () -> T) {
    println("I go with:$with")
    val place = where()
    println("and")
    when(place) {
        is String -> println("We call a taxi and go to the $place")
        else -> print("We just go for a walk near home")
    }
}

fun main() {
    val partner = "Morfey"
    go(partner) { cityCenter() }
}

fun cityCenter() = "city center"