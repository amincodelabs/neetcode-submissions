class Solution {
   public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> memo = vector(m, vector(n, -1));
        return dfs(m, n, 0, 0, memo);
    }

   private:
    int dfs(int m, int n, int r, int c, vector<vector<int>>& memo) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        if (r >= m || c >= n) {
            return 0;
        }
        if (memo[r][c] != -1) {
            return memo[r][c];
        }
        return memo[r][c] = dfs(m, n, r + 1, c, memo) + dfs(m, n, r, c + 1, memo);
    }
};
