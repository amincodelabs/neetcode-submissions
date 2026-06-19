class Solution {
   public:
    string longestCommonPrefix(vector<string>& strs) {
        int row = strs.size();
        int col = INT_MAX;
        for (string& s : strs) {
            col = std::min(col, (int)s.length());
        }

        string result = "";

        for (int c = 0; c < col; c++) {
            for (int r = 1; r < row; r++) {
                if (strs[r][c] != strs[r - 1][c]) {
                    return result;
                }
            }
            result += strs[0][c];
        }

        return result;
    }
};

/*
    b   a   t
    b   a   g
    b   a   n   k
    b   a   n   d
*/