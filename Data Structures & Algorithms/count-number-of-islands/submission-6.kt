// DFS - Iterative
// Time O(R * C)
// Space O(R * C)
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0

        val directions = arrayOf(
            intArrayOf(1, 0),   // down
            intArrayOf(-1, 0),  // up
            intArrayOf(0, 1),   // right
            intArrayOf(0, -1)   // left
        )

        for (r in 0 until rows) {
            for (c in 0 until cols) {

                if (grid[r][c] == '1') {
                    islands++

                    val stack = ArrayDeque<Pair<Int, Int>>()
                    stack.add(r to c)

                    while (stack.isNotEmpty()) {
                        val (row, col) = stack.removeLast()

                        // boundary + visited check
                        if (
                            row < 0 || row >= rows ||
                            col < 0 || col >= cols ||
                            grid[row][col] == '0'
                        ) continue

                        // mark visited
                        grid[row][col] = '0'

                        // push neighbors
                        for (dir in directions) {
                            val nr = row + dir[0]
                            val nc = col + dir[1]
                            stack.add(nr to nc)
                        }
                    }
                }
            }
        }

        return islands
    }
}