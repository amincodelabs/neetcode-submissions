class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        // Brute Force
        // Time: O(n2)
        // Space: O(1)
        for(i in numbers.indices) {
            for(j in i + 1 until numbers.size) {
                val sum = numbers[i] + numbers[j]
                if(sum == target) {
                    return intArrayOf(i + 1, j + 1)
                } else if(sum > target) {
                    break
                }
            }
        }

        return intArrayOf()
    }
}
