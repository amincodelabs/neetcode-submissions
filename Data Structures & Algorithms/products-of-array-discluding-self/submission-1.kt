class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixes = IntArray(nums.size)
        val postfixes = IntArray(nums.size)

        for (i in nums.indices) {
            prefixes[i] = if (i == 0) nums[i] else nums[i] * prefixes[i - 1]
        }

        for (i in nums.lastIndex downTo 0) {
            postfixes[i] = if (i == nums.lastIndex) nums[i] else nums[i] * postfixes[i + 1]
        }

        val result = IntArray(nums.size)

        for (i in nums.indices) {
            val left = if (i == 0) 1 else prefixes[i - 1]
            val right = if (i == nums.lastIndex) 1 else postfixes[i + 1]
            result[i] = left * right
        }

        return result
    }
}