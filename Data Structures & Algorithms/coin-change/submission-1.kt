class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val INF = 1000000000
        val memo = hashMapOf(0 to 0)

        fun dfs(amt: Int): Int {
            if(amt in memo) return memo[amt]!!

            var res = INF
            for (coin in coins) {
                if (amt - coin >= 0) {
                    res = minOf(res, 1 + dfs(amt - coin))
                }
            }
            memo[amt] = res
            return res
        }

        val minCoins = dfs(amount)
        return if (minCoins >= INF) -1 else minCoins
    }
}