class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {

     fun binarySearch(left: Int, right: Int): Int {
        if(left > right) return left

        val mid = left + (right - left) / 2

        return if(target == nums[mid])
            mid
        else if(target > nums[mid])
            binarySearch(mid + 1, right)
        else
            binarySearch(left, mid - 1)
     }  

     return binarySearch(0, nums.lastIndex) 
    }
}
