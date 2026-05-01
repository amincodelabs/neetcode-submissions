class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        var dp = IntArray(n + 1)

        for (i in 2..n) {
            dp[i] = minOf(dp[i - 1] + cost[i - 1],
                          dp[i - 2] + cost[i - 2])
        }

        return dp[n]
    }
}