// Brute Force
// O(n^2)
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        
        for(i in nums.indices) {
            var currentSum = 0
            for(j in i until nums.size) {
                currentSum += nums[j]
                maxSum = maxOf(currentSum, maxSum)
            }
        }

        return maxSum
    }
}
