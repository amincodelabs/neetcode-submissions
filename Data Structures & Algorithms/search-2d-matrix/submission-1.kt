class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var left = 0
        var right = m * n - 1

        while(left <= right) {
            val mid = (left + right) / 2
            val value = matrix[mid / n][mid % n]
            if(target == value) {
                return true
            } else if(target > value) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return false
    }
}
