class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        

        while(start <= end) {
            val mid = (start + end) / 2
            if(nums[mid] == target) {
                return mid
            } else if(nums[mid] < target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return -1
    }
}
