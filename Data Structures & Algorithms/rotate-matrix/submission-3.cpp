// Reverse And Transpose
// Time: O(n ^ 2), Space: O(1)
class Solution {
   public:
    void rotate(vector<vector<int>>& matrix) {
        // Reverse the matrix vertically
        // reverse(matrix.begin(), matrix.end());

        // Reverse rows manually
        int n = matrix.size();
        for (int i = 0; i < n / 2; ++i) {
            swap(matrix[i], matrix[n - 1 - i]);
        }

        // Transpose the matrix
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j) swap(matrix[i][j], matrix[j][i]);
        }
    }
};
