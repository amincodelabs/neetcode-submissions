class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size
        val path = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, i: Int): Boolean {
            // Base case: found the complete word
            if (i == word.length) {
                return true
            }
            // Bounds check and character match check
            if (
                r < 0 || c < 0 ||
                r >= rows || c >= cols ||
                Pair(r, c) in path ||
                board[r][c] != word[i]
            ) {
                return false
            }

            path.add(Pair(r, c))
            val result = (
                dfs(r + 1, c, i + 1) ||
                dfs(r - 1, c, i + 1) ||
                dfs(r, c + 1, i + 1) ||
                dfs(r, c - 1, i + 1)
            )
            path.remove(Pair(r, c))

            return result
        }

        for(r in 0 until rows) {
            for(c in 0 until cols) {
                if(dfs(r, c, 0)) {
                    return true
                }
            }
        }

        return false
    }
}