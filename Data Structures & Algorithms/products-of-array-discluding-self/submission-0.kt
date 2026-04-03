class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixes = IntArray(nums.size)
        val postfixes = IntArray(nums.size)

        for(i in nums.indices) {
            if(i == 0) {
                prefixes[i] = nums[i] * 1
            } else {
                prefixes[i] = nums[i] * prefixes[i - 1]
            }
        }

        for(i in nums.size - 1 downTo 0) {
            if(i == nums.lastIndex) {
                postfixes[i] = nums[i] * 1
            } else {
                postfixes[i] = nums[i] * postfixes[i + 1]
            }
        }

        val result = IntArray(nums.size)

        for(i in nums.indices) {
            val prefix = if(i == 0) 1 else prefixes[i - 1]
            val postfix = if(i == nums.lastIndex) 1 else postfixes[i + 1]
            result[i] = prefix * postfix
        }

        return result
    }
}
