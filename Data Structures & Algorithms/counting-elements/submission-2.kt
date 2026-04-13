class Solution {
    fun countElements(arr: IntArray): Int {
        val map = HashMap<Int, Int>()
        for(e in arr) 
            map[e] = map.getOrDefault(e, 0) + 1

        var count = 0
        for(e in arr) {
            val c = map.getOrDefault(e + 1, 0)
            if(c >= 1) {
                count++
                //map[e + 1] = c - 1
            }
        }

        return count
    }
}
