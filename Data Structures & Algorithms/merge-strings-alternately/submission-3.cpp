class Solution {
   public:
    string mergeAlternately(string word1, string word2) {
        string result;
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            if (i < n) {
                result += word1[i];
            }
            if (j < m) {
                result += word2[j];
            }
            i++;
            j++;
        }

        return result;
    }
};