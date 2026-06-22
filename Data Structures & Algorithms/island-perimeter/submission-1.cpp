class Solution {
   public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        vector<vector<bool>> visited(rows, vector<bool>(cols, false));

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid, visited, rows, cols, row, col);
                }
            }
        }

        return 0;
    }

   private:
    int dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int rows, int cols, int row,
            int col) {
        // Outside grid means one exposed edge.
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 1;
        }

        // Water means one exposed edge.
        if (grid[row][col] == 0) {
            return 1;
        }

        // Already counted this land cell.
        if (visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int perimeter = 0;
        perimeter += dfs(grid, visited, rows, cols, row, col - 1);  // left
        perimeter += dfs(grid, visited, rows, cols, row - 1, col);  // up
        perimeter += dfs(grid, visited, rows, cols, row, col + 1);  // right
        perimeter += dfs(grid, visited, rows, cols, row + 1, col);  // down

        return perimeter;
    }
};