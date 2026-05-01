class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val memo = IntArray(n) { -1 }

        fun dp(i: Int): Int {
            if (i >= n) return 0
            if (memo[i] != -1) return memo[i]

            memo[i] = cost[i] + minOf(dp(i + 1), dp(i + 2))
            return memo[i]
        }

        return minOf(dp(0), dp(1))
    }
}
