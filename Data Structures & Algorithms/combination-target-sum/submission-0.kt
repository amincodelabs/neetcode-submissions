class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if (total == target) {
                res.add(ArrayList(cur))
                return
            }
            if (i >= nums.size || total > target) {
                return
            }

            cur.add(nums[i])
            dfs(i, cur, total + nums[i])
            cur.removeAt(cur.size - 1)
            dfs(i + 1, cur, total)
        }

        dfs(0, mutableListOf(), 0)
        return res
    }
}