package improve.your.kotlin.maps

fun main() {
    val banks: HashMap<String, Int> = hashMapOf(
        "Tinkoff" to 1,
        "Sberbank" to 2,
        "Sberbank" to 3,
    )
    println(banks)
}