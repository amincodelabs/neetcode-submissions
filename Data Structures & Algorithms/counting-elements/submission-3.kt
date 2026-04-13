class Solution {
    fun countElements(arr: IntArray): Int {
        val hashSet = arr.toHashSet()
        var count = 0
        for (x in arr) {
            if (hashSet.contains(x + 1)) {
                count++
            }
        }
        return count
    }
}