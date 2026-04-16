class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        fun binarySearch(left: Int, right: Int): Int {
            if (left > right) return left  // Insertion point is left
            
            val mid = left + (right - left) / 2
            
            return when {
                nums[mid] == target -> mid
                nums[mid] < target -> binarySearch(mid + 1, right)
                else -> binarySearch(left, mid - 1)
            }
        }
        
        return binarySearch(0, nums.lastIndex)
    }
}