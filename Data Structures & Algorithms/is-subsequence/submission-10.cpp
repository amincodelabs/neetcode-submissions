// Dynamic Programming - Bottom Up
class Solution {
   public:
    bool isSubsequence(string s, string t) {
        vector<vector<int>> memo(s.size(), vector<int>(t.size(), -1));
        return recursion(s, t, 0, 0, memo);
    }

   private:
    bool recursion(string& s, string& t, int i, int j, vector<vector<int>>& memo) {
        if (i == s.length()) {
            return true;
        }
        if (j == t.length()) {
            return false;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        if (s[i] == t[j]) {
            memo[i][j] = recursion(s, t, i + 1, j + 1, memo) ? 1 : 0;
        } else {
            memo[i][j] = recursion(s, t, i, j + 1, memo) ? 1 : 0;
        }

        return memo[i][j] == 1;
    }
};