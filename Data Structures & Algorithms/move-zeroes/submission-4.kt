class Solution {
    fun moveZeroes(nums: IntArray) {
        var write = 0
        for (read in nums.indices) {
            if (nums[read] != 0) {
                nums[write++] = nums[read]
            }
        }

        while (write < nums.size) {
            nums[write++] = 0
        }
    }
}