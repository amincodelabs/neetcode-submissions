class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int maxProfit = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxProfit = max(maxProfit, sell - minBuy);
            minBuy = min(minBuy, sell);
        }

        return maxProfit;
    }
};
