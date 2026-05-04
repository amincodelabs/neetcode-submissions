// Dynamic Programming - II
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        for (i in 0 until numRows) {
            val row = MutableList(i + 1) { 1 }
            for (j in 1 until i) {
                row[j] = res[i - 1][j - 1] + res[i - 1][j]
            }
            res.add(row)
        }
        return res
    }
}