class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        // Step 1: prefix products
        var prefix = 1
        for (i in nums.indices) {
            result[i] = prefix
            prefix *= nums[i]
        }

        // Step 2: postfix products
        var postfix = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] *= postfix
            postfix *= nums[i]
        }

        return result
    }
}