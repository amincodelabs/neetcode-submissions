class Solution {

    private val directions = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1
    )

    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c, rows, cols)
                    islands++
                }
            }
        }

        return islands
    }

    private fun bfs(
        grid: Array<CharArray>,
        startR: Int,
        startC: Int,
        rows: Int,
        cols: Int
    ) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(startR to startC)
        grid[startR][startC] = '0'

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()

            for ((dr, dc) in directions) {
                val nr = r + dr
                val nc = c + dc

                if (nr !in 0 until rows || nc !in 0 until cols) continue
                if (grid[nr][nc] == '0') continue

                grid[nr][nc] = '0'
                queue.add(nr to nc)
            }
        }
    }
}