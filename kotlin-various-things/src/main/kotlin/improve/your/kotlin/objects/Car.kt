package improve.your.kotlin.objects

import improve.your.kotlin.common.Car


object MazdaCar {
    val volume : Float = 1.5f
    val brand = "mazda"
    val model = "rx-8"
    val color = "gold metallic"
    fun startEngine() {
        println("vrum-vrum")
    }
}

fun main() {
    MazdaCar.startEngine()
    Car.start()
}
