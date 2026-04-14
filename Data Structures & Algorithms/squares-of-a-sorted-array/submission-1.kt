import kotlin.math.abs

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        var l = 0
        var r = nums.size - 1
        val result = IntArray(nums.size)
        var i = result.size - 1

        while(l <= r) {
            if(abs(nums[l]) > abs(nums[r])) {
                result[i--] = nums[l] * nums[l]
                l++
            } else {
                result[i--] = nums[r] * nums[r]
                r--
            }
        }

        return result
    }
}
