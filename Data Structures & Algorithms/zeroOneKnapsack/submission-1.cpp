class Solution {
   public:
    int maximumProfit(vector<int>& profit, vector<int>& weight, int capacity) {
        int n = profit.size(), m = capacity;
        vector<vector<int>> memo(n, vector<int>(m + 1, -1));
        return calculateMaxProfit(0, profit, weight, capacity, memo);
    }

   private:
    int calculateMaxProfit(int index, vector<int>& profit, vector<int>& weight, int capacity,
                           vector<vector<int>>& memo) {
        if (index == profit.size()) {
            return 0;
        }

        if (memo[index][capacity] != -1) {
            return memo[index][capacity];
        }

        int maxProfit = calculateMaxProfit(index + 1, profit, weight, capacity, memo);

        int newCapacity = capacity - weight[index];
        if (newCapacity >= 0) {
            int p = profit[index] + calculateMaxProfit(index + 1, profit, weight, newCapacity, memo);
            maxProfit = max(maxProfit, p);
        }

        return memo[index][capacity] = maxProfit;
    }
};