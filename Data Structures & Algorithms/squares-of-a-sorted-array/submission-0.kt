class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var l = 0
        var r = nums.size - 1
        val result = IntArray(nums.size)
        var i = result.size - 1

        while(l <= r) {
            val ls = nums[l] * nums[l]
            val rs = nums[r] * nums[r]
            
            if(ls > rs) {
                result[i] = ls
                l++
            } else {
                result[i] = rs
                r--
            }

            i--
        }

        return result
    }
}
