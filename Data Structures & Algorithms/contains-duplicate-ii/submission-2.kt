class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        for (L in nums.indices) {
            for (R in L + 1 until minOf(nums.size, L + k + 1)) {
                if (nums[L] == nums[R]) {
                    return true
                }
            }
        }
        return false
    }
}