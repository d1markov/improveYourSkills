package leetCode

fun main() {
    var image: Array<IntArray> = arrayOf(intArrayOf(1, 2, 7))
    println(image[0][1])
    image += intArrayOf(1, 8, 7)
    !image.contains(intArrayOf(1, 8, 7))
}

fun floodFill(image: Array<IntArray>, row: Int, column: Int, color: Int): Array<IntArray> {
    if(row in image.indices) {

    }
    if(row >= 0 && row< image.size && column >= 0 &&  column <= image[0].size ) {
        val currentColor = image[row][column]
        // val pixel = Pixel(row, column, currentColor)
        val topNeighbour = Pixel(row - 1, column, image[row - 1][column])
        val rightNeighbour = Pixel(row, column + 1,image[row][column + 1])
        val bottomNeighbour = Pixel(row +1, column, image[row +1 ][column])
        val leftNeighbour = Pixel(row, column - 1, image[row][column - 1])
        if(currentColor != color) {
            image[row][column] = color
            i += 1
            floodFill(image, topNeighbour.row, topNeighbour.column, color)
            floodFill(image, rightNeighbour.row, rightNeighbour.column, color)
            floodFill(image, bottomNeighbour.row, bottomNeighbour.column, color)
            floodFill(image, leftNeighbour.row, leftNeighbour.column, color)
        }
    }

}


class SellStock {

    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var maxProfit = 0
        var minValue = 0
        var maxValue = 0
        for(i in prices.indices) {
            //var buyingPrice = prices[i]
            if(i > 0 && minValue == prices[i-1]) {
                break
            }
            minValue = prices[i]
            for(j in i+1 .. prices.lastIndex) { // ?
                //var sellingPrice = prices[j]
                profit = prices[j] - prices[i]
                if(profit > 0 && profit > maxProfit) {
                    maxProfit = profit
                }
                if(prices[j] < prices[i] && prices[j] < minValue) {
                    minValue = prices[j]
                }
            }
        }
        return maxProfit

    }
}

class FasterSolution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var maxProfit = 0
        var minValue =  0
        var minIndex = -1
        var maxValue = 0
        var maxindex = -1
        for(i in prices.indices) {
            //var buyingPrice = prices[i]
            if(i > 0 && minValue == prices[i-1]) {
                break
            }
            minValue = prices[i]
            minIndex = i
            maxValue = prices[i]
            maxindex = i
            for(j in i+1 .. prices.lastIndex) { // ?
                //var sellingPrice = prices[j]
                profit = prices[j] - prices[i]
                if(profit > 0 && profit > maxProfit) {
                    maxProfit = profit
                }
                if(prices[j] < prices[i] && prices[j] < minValue) {
                    minValue = prices[j]
                    minIndex = j
                }
                if(prices[j] > maxValue) {
                    maxValue = prices[j]
                    maxindex = j
                }
            }
            if(minIndex < maxindex && prices[maxindex] - prices[minIndex] > maxProfit) {
                maxProfit = prices[maxindex] - prices[minIndex]
                break
            }
        }
        return maxProfit

    }
}