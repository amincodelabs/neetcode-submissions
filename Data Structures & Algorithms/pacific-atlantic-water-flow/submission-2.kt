class Solution {
    private val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size

        val canReachPacific = Array(rows) { BooleanArray(cols) }
        val canReachAtlantic = Array(rows) { BooleanArray(cols) }

        fun dfs(r: Int, c: Int, reachable: Array<BooleanArray>, previousHeight: Int) {
            if (
                r !in 0 until rows ||
                c !in 0 until cols ||
                reachable[r][c] ||
                heights[r][c] < previousHeight
            ) {
                return
            }

            reachable[r][c] = true

            for (dir in directions) {
                dfs(
                    r + dir[0],
                    c + dir[1],
                    reachable,
                    heights[r][c]
                )
            }
        }

        for (c in 0 until cols) {
            dfs(0, c, canReachPacific, heights[0][c])
            dfs(rows - 1, c, canReachAtlantic, heights[rows - 1][c])
        }

        for (r in 0 until rows) {
            dfs(r, 0, canReachPacific, heights[r][0])
            dfs(r, cols - 1, canReachAtlantic, heights[r][cols - 1])
        }

        val result = mutableListOf<List<Int>>()

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }
}