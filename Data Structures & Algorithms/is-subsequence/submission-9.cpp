// Recursion
class Solution {
   public:
    bool isSubsequence(string s, string t) { return recursion(s, t, 0, 0); }

   private:
    bool recursion(string& s, string& t, int i, int j) {
        if (i == s.length()) {
            return true;
        }
        if (j == t.length()) {
            return false;
        }
        if (s[i] == t[j]) {
            return recursion(s, t, i + 1, j + 1);
        }
        return recursion(s, t, i, j + 1);
    }
};