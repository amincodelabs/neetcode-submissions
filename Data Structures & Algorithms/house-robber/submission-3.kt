class Solution {
    fun rob(nums: IntArray): Int {
        var prev1 = 0 // i - 1
        var prev2 = 0 // i - 2

        for(money in nums) {
            val take = money + prev2
            val skip = prev1
            val best = maxOf(take, skip)

            prev2 = prev1
            prev1 = best
        }

        return prev1
    }
}