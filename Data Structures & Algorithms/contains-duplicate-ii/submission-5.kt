class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window = HashSet<Int>()
        var L = 0
        for(R in nums.indices) {

            if(R - L > k) {
                window.remove(nums[L])
                L++
            }

            if(nums[R] in window) {
                return true
            }

            window.add(nums[R])
            
        }

        return false
    }
}