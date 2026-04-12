class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var max = -1

        for(i in arr.lastIndex downTo 0) {
            val current = arr[i]
            arr[i] = max
            max = maxOf(max, current)
        }

        return arr
    }
}
