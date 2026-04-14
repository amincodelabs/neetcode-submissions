class Solution {
    fun moveZeroes(nums: IntArray) {
        var write = 0
        var read = 1

        while(read < nums.size) {
            if(nums[write] != 0) {
                write++
                read = write + 1
                continue
            }
            if(nums[read] != 0) {
                nums[write++] = nums[read]
                nums[read] = 0
            }
            read++
        }
    }
}
