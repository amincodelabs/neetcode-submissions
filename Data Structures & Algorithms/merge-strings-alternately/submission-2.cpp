class Solution {
   public:
    string mergeAlternately(string word1, string word2) {
        string result;
        int n = min(word1.length(), word2.length());

        for (int i = 0; i < n; i++) {
            result += word1[i];
            result += word2[i];
        }

        for (int i = n; i < word1.length(); i++) {
            result += word1[i];
        }
        for (int i = n; i < word2.length(); i++) {
            result += word2[i];
        }

        return result;
    }
};