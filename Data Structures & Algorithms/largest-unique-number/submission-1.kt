class Solution {
    fun largestUniqueNumber(nums: IntArray): Int {
        var max = -1
        val map = HashMap<Int, Int>()

        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        for(num in nums) {
            if(num > max && map[num] == 1) {
                max = num
            }
        }

        return max
    }
}
