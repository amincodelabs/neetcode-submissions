class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.size

        while (true) {
            val candidate = nums[kotlin.random.Random.nextInt(n)]
            var count = 0
            for (num in nums) {
                if (num == candidate) {
                    count++
                }
            }
            if (count > n / 2) {
                return candidate
            }
        }
    }
}