class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val memo = Array(nums.size) { IntArray(2) { -1 } }

        fun dfs(i: Int, flag: Int): Int {
            if (i >= nums.size || (flag == 1 && i == nums.size - 1)) {
                return 0
            }
            if (memo[i][flag] != -1) {
                return memo[i][flag]
            }
            memo[i][flag] = maxOf(dfs(i + 1, flag),
                                  nums[i] + dfs(i + 2, flag or if (i == 0) 1 else 0))
            return memo[i][flag]
        }

        return maxOf(dfs(0, 1), dfs(1, 0))
    }
}