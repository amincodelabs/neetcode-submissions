class Solution {
    fun largestUniqueNumber(nums: IntArray): Int {
        val frequencyMap = mutableMapOf<Int, Int>()
        
        // Count frequencies
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }
        
        var max = -1
        
        // Check only unique numbers from the map
        for ((num, count) in frequencyMap) {
            if (count == 1 && num > max) {
                max = num
            }
        }
        
        return max
    }
}