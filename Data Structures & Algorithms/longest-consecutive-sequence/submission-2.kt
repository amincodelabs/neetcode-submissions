// Brute Force
// O(n ^ 2)
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var longest = 0
        val set = nums.toSet()

        for(num in nums) {
            var length = 0
            var current = num
            while(current in set) {
                length++
                current++
            }
            longest = maxOf(longest, length)
        }

        return longest
    }
}
