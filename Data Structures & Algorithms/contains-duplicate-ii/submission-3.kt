class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()

        for(i in nums.indices) {
            if(map.containsKey(nums[i]) && i - map[nums[i]]!! <= k) {
                return true
            }
            map[nums[i]] = i
        }

        return false
    }
}