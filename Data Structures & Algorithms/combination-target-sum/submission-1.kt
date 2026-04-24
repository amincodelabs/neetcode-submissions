class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(index: Int, total: Int, current: MutableList<Int>) {
            if(total == target) {
                result.add(ArrayList(current))
                return
            }
            if(index >= nums.size || total > target) {
                return
            }

            current.add(nums[index])
            dfs(index, total + nums[index], current)
            current.removeLast()
            dfs(index + 1, total, current)
        }

        dfs(0, 0, mutableListOf())
        return result
    }
}