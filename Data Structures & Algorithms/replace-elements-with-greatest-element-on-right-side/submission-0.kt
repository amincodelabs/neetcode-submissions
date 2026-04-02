class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val result = IntArray(arr.size)
        var g = -1

        for(i in arr.lastIndex downTo 0) {
            result[i] = g
            g = maxOf(g, arr[i])
        }

        return result
    }
}
