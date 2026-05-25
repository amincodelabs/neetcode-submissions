// DFS - Iterative
// Time O(R * C)
// Space O(R * C)
class Solution {
   public:
    int ROWS = 0;
    int COLS = 0;

    int numIslands(vector<vector<char>>& grid) {
        ROWS = grid.size();
        COLS = grid[0].size();
        int island = 0;
        vector<vector<int>> directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '0') {
                    continue;
                }

                island++;
                std::stack<std::pair<int, int>> stack;
                stack.push({r, c});
                while (!stack.empty()) {
                    std::pair<int, int> vertex = stack.top();
                    stack.pop();
                    int row = vertex.first;
                    int col = vertex.second;
                    if (row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] == '0') {
                        continue;
                    }
                    grid[row][col] = '0';
                    for (auto dir : directions) {
                        int nr = row + dir[0];
                        int nc = col + dir[1];

                        stack.push({nr, nc});
                    }
                }
            }
        }
        return island;
    }
};