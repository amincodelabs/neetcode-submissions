class Solution {
   public:
    int change(int amount, vector<int>& coins) {
        sort(coins.begin(), coins.end());
        vector<vector<int>> memo(coins.size() + 1, vector<int>(amount + 1, -1));
        return dfs(coins, 0, amount, memo);
    }

   private:
    int dfs(const vector<int>& coins, int index, int amount, vector<vector<int>>& memo) {
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.size()) {
            return 0;
        }
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int result = 0;
        result = dfs(coins, index + 1, amount, memo);
        if (amount >= coins[index]) {

            result += dfs(coins, index, amount - coins[index], memo);
        }

        memo[index][amount] = result;
        return memo[index][amount];
    }
};
