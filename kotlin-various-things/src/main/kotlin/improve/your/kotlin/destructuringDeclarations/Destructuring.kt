package improve.your.kotlin.destructuringDeclarations

import improve.your.kotlin.common.Car

fun main() {
    val (brand1, model1, color1) = Car("lada", "sedan", "baklajan")
   // val (brand2, model2, color2) = CarNoDataCLass("uaz", "patriot", "rzaviy") // doesnt work you need declare component function
    val (brand3, model3, color3) = CarWithComponentFunction("delorian", "?", "gray metallic")
}

class CarNoDataCLass(
    val brand: String,
    val model : String,
    val color: String
)

class CarWithComponentFunction(
    private val brand: String,
    private val model : String,
    private val color: String
) {
    operator fun component1() = brand
    operator fun component2() = model
    operator fun component3() = color
}