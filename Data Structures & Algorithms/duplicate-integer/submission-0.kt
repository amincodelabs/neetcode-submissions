class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val map = HashMap<Int, Int>()

        for(i in nums.indices) {
            val current = nums[i]
            map[current] = map.getOrDefault(current, 0) + 1
        }
        
        map.forEach {
            if(it.value > 1) return true
        }

        return false
    }
}
