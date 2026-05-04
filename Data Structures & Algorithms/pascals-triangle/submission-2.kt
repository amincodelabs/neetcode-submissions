class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf(listOf(1))

        for (i in 0 until numRows - 1) {
            val temp = listOf(0) + res.last() + listOf(0)
            val row = mutableListOf<Int>()
            for (j in 0 until res.last().size + 1) {
                row.add(temp[j] + temp[j + 1])
            }
            res.add(row)
        }
        return res
    }
}