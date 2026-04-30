class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1){ -1 }

        fun dfs(k: Int): Int {
            if(k > n) return 0
            if(k == n) return 1
            if(dp[k] != -1) return dp[k]

            dp[k] = dfs(k + 1) + dfs(k + 2)
            return dp[k]
        }

        return dfs(0)
    }
}
