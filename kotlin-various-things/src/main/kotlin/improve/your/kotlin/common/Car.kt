package improve.your.kotlin.common

data class Car(
    val brand: String,
    val model : String,
    val color: String
) {
    companion object Engine {
        fun start() {
            println("engine Started")
        }
    }
}