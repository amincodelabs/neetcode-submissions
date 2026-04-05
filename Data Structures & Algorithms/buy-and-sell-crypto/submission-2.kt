class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxP = 0
        var minBuy = Int.MAX_VALUE

        for (sell in prices) {
            maxP = maxOf(maxP, sell - minBuy)
            minBuy = minOf(minBuy, sell)
        }
        return maxP
    }
}