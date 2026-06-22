class Solution {
   public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<int>> memo(rows, vector<int>(cols, -1));
        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    return dfs(grid, rows, cols, row, col, memo);
                }
            }
        }

        return result;
    }

   private:
    int dfs(vector<vector<int>>& grid, int rows, int cols, int row, int col,
            vector<vector<int>>& memo) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 1;
        }
        if (grid[row][col] == 0) {
            return 1;
        }
        if (memo[row][col] != -1) {
            return 0;
        }

        memo[row][col] = 0;
        int result = 0;
        result += dfs(grid, rows, cols, row, col - 1, memo);
        result += dfs(grid, rows, cols, row - 1, col, memo);
        result += dfs(grid, rows, cols, row, col + 1, memo);
        result += dfs(grid, rows, cols, row + 1, col, memo);

        return memo[row][col] = result;
    }
};