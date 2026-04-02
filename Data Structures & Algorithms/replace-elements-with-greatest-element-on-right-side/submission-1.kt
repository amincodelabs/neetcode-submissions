class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var g = -1

        for(i in arr.lastIndex downTo 0) {
            val current = arr[i]
            arr[i] = g
            g = maxOf(g, current)
        }

        return arr
    }
}
