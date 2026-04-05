class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var left = 0
        var right = 1

        while(right < prices.size) {
            if(prices[right] - prices[left] > maxProfit) {

            }
            val today = prices[right] - prices[left]
            maxProfit = maxOf(maxProfit, today)
            if(prices[right] < prices[left]) {
                left = right
            }
            right++
        }

        return maxProfit
    }
}
