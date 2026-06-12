class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();

        // Scan rows
        for (auto &row : board) {
            unordered_set<char> mySet;
            for (char num : row) {
                if (num == '.') continue;
                if (mySet.count(num)) {
                    return false;
                }
                mySet.insert(num);
            }
        }

        // Scan cols
        for (int c = 0; c < n; c++) {
            unordered_set<char> mySet;
            for (int r = 0; r < n; r++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (mySet.count(ch)) {
                    return false;
                }
                mySet.insert(ch);
            }
        }

        // Scan 3x3 boxes
        for (int r = 0; r < n; r += 3) {
            for (int c = 0; c < n; c += 3) {
                unordered_set<char> mySet;
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        char ch = board[i][j];
                        if (ch == '.') continue;
                        if (mySet.count(ch)) {
                            return false;
                        }
                        mySet.insert(ch);
                    }
                }
            }
        }

        return true;
    }
};