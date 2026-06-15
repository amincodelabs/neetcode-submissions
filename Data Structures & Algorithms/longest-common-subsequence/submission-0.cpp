class Solution {
   public:
    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> memo(text2.length(), vector<int>(text1.length(), -1));
        return dfs(text1, text2, 0, 0, memo);
    }

   private:
    int dfs(string& text1, string& text2, int i, int j, vector<vector<int>>& memo) {
        if (i >= text2.length()) {
            return 0;
        }
        if (j >= text1.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            
            return memo[i][j];
        }
        if (text2[i] == text1[j]) {
            return memo[i][j] = 1 + dfs(text1, text2, i + 1, j + 1, memo);
        }
        return memo[i][j] = max(dfs(text1, text2, i, j + 1, memo), dfs(text1, text2, i + 1, j, memo));
    }
};