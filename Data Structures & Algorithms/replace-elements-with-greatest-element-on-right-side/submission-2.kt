class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        for(i in arr.indices) {
            var max = 0
            for(j in i + 1 until arr.size) {
                max = maxOf(max, arr[j])
            }
            arr[i] = if(i == arr.lastIndex) -1 else max
        }

        return arr
    }
}
