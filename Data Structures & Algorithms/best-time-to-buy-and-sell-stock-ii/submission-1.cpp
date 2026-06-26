// Dynamic Programming (Top-Down)

class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> memo(n, vector<int>(2, -1));
        return rec(prices, memo, 0, 0);
    }

   private:
    int rec(vector<int>& prices, vector<vector<int>>& memo, int index, int bought) {
        if (index == prices.size()) {
            return 0;
        }
        if (memo[index][bought] != -1) {
            return memo[index][bought];
        }

        int result = rec(prices, memo, index + 1, bought);
        if (bought == 1) {
            result = max(result, prices[index] + rec(prices, memo, index + 1, 0));
        } else {
            result = max(result, -prices[index] + rec(prices, memo, index + 1, 1));
        }
        memo[index][bought] = result;

        return result;
    }
};