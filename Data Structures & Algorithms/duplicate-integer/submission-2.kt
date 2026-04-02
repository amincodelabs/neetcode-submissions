class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val map = HashMap<Int, Int>()

        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        map.forEach {
            if(it.value > 1) {
                return true
            }
        }

        return false
    }
}
