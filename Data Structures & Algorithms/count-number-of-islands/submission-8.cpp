// DFS - Recursive
// Time O(R * C)
// Space O(R * C) - Call Stack
class Solution {
public:
    int ROWS = 0;
    int COLS = 0;

    int numIslands(vector<vector<char>>& grid) {
        ROWS = grid.size();
        COLS = grid[0].size();
        int islands = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }

        return islands;
    }

    void dfs(vector<vector<char>>& grid, int r, int c) {
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // Mark as 0 so next time will not be counted

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
    
};
