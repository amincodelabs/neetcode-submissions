// Brute Force
// O(n ^ 2)
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        nums.sort()
        var maxLen = 0
        for(subject in nums) {
            var len = 0
            for(num in nums) {
                if(num == subject + len) {
                    len++
                }
            }
            maxLen = maxOf(maxLen, len)
        }
        return maxLen
    }
}
