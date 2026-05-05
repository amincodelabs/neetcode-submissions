// Sorting
// Time O(nlogn)
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        nums.sort()

        var res = 0
        var curr = nums[0]
        var streak = 0
        var i = 0
        while (i < nums.size) {
            if (curr != nums[i]) {
                curr = nums[i]
                streak = 0
            }
            while (i < nums.size && nums[i] == curr) {
                i++
            }
            streak++
            curr++
            res = maxOf(res, streak)
        }
        return res
    }
}