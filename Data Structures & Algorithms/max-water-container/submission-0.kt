class Solution {
    fun maxArea(heights: IntArray): Int {
        // Brute Force
        // Time: O(n2)
        // Space: O(1)

        var max = 0

        for(i in heights.indices) {
            for(j in i + 1 until heights.size) {
                val h = minOf(heights[i], heights[j])
                val w = j - i
                max = maxOf(max, h * w)
            }
        }

        return max
    }
}
