class Solution {
    fun findMin(nums: IntArray): Int {
        var res = nums[0]
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = minOf(res, nums[l])
                break
            }

            val m = l + (r - l) / 2
            res = minOf(res, nums[m])

            if (nums[m] >= nums[l]) {
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return res
    }
}