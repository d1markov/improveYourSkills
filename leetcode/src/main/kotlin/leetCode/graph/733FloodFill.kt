package leetCode.graph

/** Идея в том чтобы использовать рекурсию
 */
class Solution {
    //sr - row, sc - column
    private var i = 0
    private var changedColor: Int? = null
    fun floodFill(image: Array<IntArray>, row: Int, column: Int, color: Int): Array<IntArray> {
        if (row in image.indices && column in image[0].indices) {
            val currentColor = image[row][column]
            if (changedColor == null) {
                changedColor = currentColor
            }
            // val pixel = Pixel(row, column, currentColor)
            val topNeighbour = image.getPixel(row - 1, column)
            val rightNeighbour = image.getPixel(row, column + 1)
            val bottomNeighbour = image.getPixel(row + 1, column)
            val leftNeighbour = image.getPixel(row, column - 1)
            if (currentColor != color && currentColor == changedColor) {
                image[row][column] = color
                i += 1
                topNeighbour?.let {
                    floodFill(image, it.row, it.column, color)
                }
                rightNeighbour?.let {
                    floodFill(image, it.row, it.column, color)
                }
                bottomNeighbour?.let {
                    floodFill(image, it.row, it.column, color)
                }
                leftNeighbour?.let {
                    floodFill(image, it.row, it.column, color)
                }
            }
        }
        return image
    }
}

data class Pixel(
    val row: Int,
    val column: Int,
    val color: Int
)

fun Array<IntArray>.getPixel(row: Int, column: Int): Pixel? =
    if (row in this.indices && column in this[0].indices) {
        Pixel(row, column, this[row][column])
    } else {
        null
    }
