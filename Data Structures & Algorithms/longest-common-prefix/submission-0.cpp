class Solution {
   public:
    string longestCommonPrefix(vector<string>& strs) {
        int smallest = INT_MAX;
        for (string& s : strs) {
            smallest = std::min(smallest, (int)s.length());
        }

        string result = "";

        for (int i = 0; i < smallest; i++) {
            char c = strs[0][i];
            for (string& s : strs) {
                if (s[i] != c) {
                    return result;
                }
            }
            result += c;
        }

        return result;
    }
};