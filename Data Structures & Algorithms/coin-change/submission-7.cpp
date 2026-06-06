class Solution {
   public:
    vector<int> memo;

    int coinChange(vector<int>& coins, int amount) {
        memo.assign(amount + 1, -2);
        return dfs(coins, amount, 0);
    }

   private:
    int dfs(vector<int>& coins, int targetAmount, int currentSum) {
        // Reached the target amount exactly
        if (currentSum == targetAmount) {
            return 0;
        }

        // Exceeded the target amount, invalid path
        if (currentSum > targetAmount) {
            return -1;
        }

        // If we already solved this state, reuse it
        if (memo[currentSum] != -2) {
            return memo[currentSum];
        }

        int minCoins = INT_MAX;

        for (int coin : coins) {
            // Avoid integer overflow and useless paths
            if (coin > targetAmount - currentSum) {
                continue;
            }

            int result = dfs(coins, targetAmount, currentSum + coin);

            // If the next path is valid, count the current coin
            if (result != -1) {
                minCoins = min(minCoins, result + 1);
            }
        }

        // Save the result for this currentSum
        if (minCoins == INT_MAX) {
            memo[currentSum] = -1;
        } else {
            memo[currentSum] = minCoins;
        }

        return memo[currentSum];
    }
};