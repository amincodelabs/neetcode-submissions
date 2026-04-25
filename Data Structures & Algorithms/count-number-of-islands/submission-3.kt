// BFS - Iterative
// Time O(R * C)
// Space O(R * C) - Call Stack
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val directions = arrayOf(intArrayOf(1, 0),
                                 intArrayOf(-1, 0),
                                 intArrayOf(0, 1),
                                 intArrayOf(0, -1))
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0

        fun bfs(r: Int, c: Int) {
            val q: Queue<IntArray> = LinkedList()
            grid[r][c] = '0'
            q.add(intArrayOf(r, c))

            while (q.isNotEmpty()) {
                val (row, col) = q.poll()
                for (dir in directions) {
                    val nr = row + dir[0]
                    val nc = col + dir[1]
                    if (nr < 0 || nc < 0 || nr >= rows ||
                        nc >= cols || grid[nr][nc] == '0') {
                        continue
                    }
                    q.add(intArrayOf(nr, nc))
                    grid[nr][nc] = '0'
                }
            }
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    bfs(r, c)
                    islands++
                }
            }
        }

        return islands
    }
}