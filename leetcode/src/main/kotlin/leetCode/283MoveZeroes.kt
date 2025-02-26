package leetCode

fun main() {
    moveZeroesV2(intArrayOf(0, 1, 0, 0, 12))
}

fun moveZeroes(nums: IntArray): Unit {
    for (i in 0..nums.lastIndex) {
        if (nums[i] == 0) {
            for (j in i..nums.lastIndex) {
                nums[j] = if (j < nums.lastIndex) nums[j + 1] else 0
            }
        }
        println(nums[i])
    }
}

fun moveZeroesV2(nums: IntArray): Unit {
    var index = 0
    var zeroesCount = 0
    while (index < nums.lastIndex) {
        if (nums[index] == 0 && nums[index] < nums.size - zeroesCount) {
            zeroesCount ++
            for (j in index..nums.lastIndex) {
                nums[j] = if (j < nums.lastIndex) nums[j + 1] else 0
                index = 0
            }
        } else {
            index++
        }
    }
    println(nums.joinToString(""))
}
