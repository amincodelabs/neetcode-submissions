class Solution {
    fun maxArea(heights: IntArray): Int {
        // Two Pointers
        // Time: O(n)
        // Space: O(1)

        var max = 0
        var l = 0
        var r = heights.size - 1

        while (l < r) {
            val area = minOf(heights[l], heights[r]) * (r - l)
            max = maxOf(max, area)
            if (heights[l] <= heights[r]) {
                l++
            } else {
                r--
            }
        }

        return max
    }
}
