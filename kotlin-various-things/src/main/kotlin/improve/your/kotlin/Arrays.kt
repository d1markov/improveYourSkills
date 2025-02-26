package improve.your.kotlin


fun main() {
    val pixels = arrayOf(intArrayOf(0,1,8), intArrayOf(11,18,3))
    pixels[0][2] = 1
    pixels.forEach { row ->
        row.forEach {
            print(it)
        }
        println()
    }

}


