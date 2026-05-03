class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.size
        val bit = IntArray(32)

        for (num in nums) {
            for (i in 0 until 32) {
                bit[i] += (num shr i) and 1
            }
        }

        var res = 0
        for (i in 0 until 32) {
            if (bit[i] > n / 2) {
                res = res or (1 shl i)
            }
        }
        return res
    }
}