class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var count = 0
        for(num in nums) {
            if(num == 0) {
                count = 0 
                continue
            }
            else count++
            max = maxOf(max, count)
        }

        return max
    }
}
