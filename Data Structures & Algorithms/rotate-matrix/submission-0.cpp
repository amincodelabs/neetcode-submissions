// Brute Force
// Time: O(n ^ 2), Space: O(n ^ 2)
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<vector<int>> rotated(n, vector<int>(n));

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                rotated[y][n - 1 - x] = matrix[x][y];
            }
        }

        matrix = rotated;
    }
};
