class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = MutableList(numRows) { row ->
            MutableList(row + 1) { 1 }
        }

        for (row in 2 until numRows) {
            for (col in 1 until row) {
                triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col]
            }
        }

        // return as immutable view (still backed by mutable lists, but typed as List)
        return triangle.map { it.toList() }
    }
}