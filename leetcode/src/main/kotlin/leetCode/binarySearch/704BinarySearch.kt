package leetCode.binarySearch

fun main() {
    val nums: IntArray = intArrayOf(-1, 6, 7, 8, 10, 19) //size = 4, lastindex = 3
    println(search2(nums, 1))
    //  println(1/2)
}

fun search2(nums: IntArray, target: Int): Int {
    var targetIndex = -1
    if (target < nums.first() || target > nums.last()) {
        return targetIndex
    }
    var startIndex = 0
    var stopIndex = nums.lastIndex
    var centerIndex = -1
    while (centerIndex <= nums.lastIndex && startIndex <= stopIndex && centerIndex != startIndex) {
        centerIndex = (stopIndex - startIndex) / 2 + startIndex
        if (nums[centerIndex] == target) {
            targetIndex = centerIndex
            break
        }
        if (nums[centerIndex] < target) {
            startIndex = centerIndex + 1
        }
        if (nums[centerIndex] > target) {
            stopIndex = centerIndex
        }
    }
    return targetIndex
}

fun search(nums: IntArray, target: Int): Int {
    var targetIndex = -1
    var startIndex = 0
    var stopIndex = nums.lastIndex
    var centerIndex = -1
    for (i in nums.size downTo -2 step 2) {
        centerIndex = (stopIndex - startIndex) / 2 + startIndex
        if (centerIndex > nums.lastIndex) {
            break
        }
        if (nums[centerIndex] == target) {
            targetIndex = centerIndex
            break
        }
        if (nums[centerIndex] > target) {
            stopIndex = centerIndex
        } else if (nums[centerIndex] < target) {
            startIndex = centerIndex + 1
        }
    }
    return targetIndex
}


