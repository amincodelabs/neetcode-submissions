class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var row = 0
        for(i in 1 until m) {
            val s = matrix[row][n - 1]
            if(s == target) {
                return true
            } else if(target > s) {
                row++
            } else {
                break
            }
        }

        var start = 0
        var end = matrix[row].lastIndex

        while(start <= end) {
            val mid = (start + end) / 2
            if(target == matrix[row][mid]) {
                return true
            } else if(target > matrix[row][mid]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return false

    }
}
