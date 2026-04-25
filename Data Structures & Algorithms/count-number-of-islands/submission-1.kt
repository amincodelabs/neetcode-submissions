// DFS - Iterative
// Time O(R * C)
// Space O(R * C) - Call Stack
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0

        fun dfs(r: Int, c: Int) {
            if(
                r !in 0 until rows ||
                c !in 0 until cols ||
                grid[r][c] == '0'
            ) {
                return
            }

            grid[r][c] = '0' // Mark as 0 so next time will not be counted

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        for(r in 0 until rows)
            for(c in 0 until cols)
                if(grid[r][c] == '1') {
                    islands++
                    dfs(r, c)
                }

        return islands
    }
}
