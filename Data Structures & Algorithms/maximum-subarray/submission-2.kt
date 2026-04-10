// Kadane's Algorithm
// O(n)
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var currentSum = 0

        for(num in nums) {
            currentSum = maxOf(currentSum, 0)
            currentSum += num
            maxSum = maxOf(currentSum, maxSum)
        }

        return maxSum
    }
}
