class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()

        for(i in nums.indices) {
            val key = nums[i]
            if(map.containsKey(key) && (i - map[key]!! <= k)) {
                return true
            }
            map[key] = i
        }

        return false
    }
}