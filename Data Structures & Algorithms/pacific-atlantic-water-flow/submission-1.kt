// Brute Force
/*
Brute Force
Time:  O((R * C) * (R * C)) = O(R² * C²)
Space: O(R * C)
*/
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
        val result = mutableListOf<List<Int>>()

        fun dfs(r: Int, c: Int, prevHeight: Int, visited: Array<BooleanArray>): Pair<Boolean, Boolean> {
            if (r < 0 || c < 0) return true to false      // Pacific
            if (r >= rows || c >= cols) return false to true // Atlantic

            if (visited[r][c]) return false to false
            if (heights[r][c] > prevHeight) return false to false

            visited[r][c] = true

            var canReachPacific = false
            var canReachAtlantic = false

            for (dir in directions) {
                val nextR = r + dir[0]
                val nextC = c + dir[1]

                val (pacific, atlantic) = dfs(
                    nextR,
                    nextC,
                    heights[r][c],
                    visited
                )

                canReachPacific = canReachPacific || pacific
                canReachAtlantic = canReachAtlantic || atlantic

                if (canReachPacific && canReachAtlantic) break
            }

            return canReachPacific to canReachAtlantic
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                val visited = Array(rows) { BooleanArray(cols) }

                val (canReachPacific, canReachAtlantic) =
                    dfs(r, c, Int.MAX_VALUE, visited)

                if (canReachPacific && canReachAtlantic) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }
}