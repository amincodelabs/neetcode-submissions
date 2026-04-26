class Solution {

    fun countPaths(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val visited = Array(rows) { BooleanArray(cols) }

        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        fun dfs(row: Int, col: Int): Int {
            if (
                row !in 0 until rows ||
                col !in 0 until cols ||
                visited[row][col] ||
                grid[row][col] == 1
            ) {
                return 0
            }

            if (row == rows - 1 && col == cols - 1) {
                return 1
            }

            visited[row][col] = true

            var paths = 0
            for ((dr, dc) in directions) {
                paths += dfs(row + dr, col + dc)
            }

            visited[row][col] = false

            return paths
        }

        return dfs(0, 0)
    }
}