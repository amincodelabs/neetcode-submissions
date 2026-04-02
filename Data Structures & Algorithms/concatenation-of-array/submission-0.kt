class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n*2)

        for(i in 0 until n) {
            ans[i] = nums[i]
            println("$i: i")
        }
        println("size: ${ans.size}")

        for(i in n until ans.size) {
            ans[i] = nums[i - n]
            println("i: $i")
        }

        return ans
    }
}
