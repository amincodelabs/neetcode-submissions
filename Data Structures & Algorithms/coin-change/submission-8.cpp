class Solution {
   public:
    unordered_map<int, int> memo;

    int coinChange(vector<int>& coins, int amount) {
        int minCoins = dfs(amount, coins);
        return minCoins == INT_MAX ? -1 : minCoins;
    }

    int dfs(int amount, vector<int>& coins) {
        if (amount == 0) {
            return 0;
        }
        if (memo.find(amount) != memo.end()) {
            return memo[amount];
        }

        int minCoin = INT_MAX;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int result = dfs(amount - coin, coins);
                if (result != INT_MAX) {
                    minCoin = min(minCoin, result + 1);
                }
            }
        }

        memo[amount] = minCoin;
        return minCoin;
    }
};