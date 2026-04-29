class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        var cache = IntArray(n+1){-1}

        fun recursive(i: Int): Int {
            if (i >= n) return 0
            if (cache[i] != -1) return cache[i]
            cache[i] = maxOf(recursive(i + 1), nums[i] + recursive(i + 2))
            return cache[i]
        }
        return recursive(0)
    }
}