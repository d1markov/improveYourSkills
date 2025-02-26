package leetCode.seventy5

fun main() {
    println(
        twoSum(intArrayOf(3, 4, 2), 6).joinToString("")
    )
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val indices: IntArray = IntArray(2)
    for (num1Index in nums.indices) {
        for (num2Index in nums.indices) {
            if (num1Index == num2Index) {
                continue
            }
            if (nums[num1Index] + nums[num2Index] == target) {
                indices.set(0, nums[num1Index])
                indices.set(1, nums[num2Index])
                break
            }
        }
    }
    return indices
}