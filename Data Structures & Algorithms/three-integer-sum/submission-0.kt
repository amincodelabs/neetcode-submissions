class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for(i in nums.indices) {
            val a = nums[i]
            if(a > 0) break // Sum of a, l, r never will be 0
            if(i > 0 && a == nums[i - 1]) continue

            var l = i + 1
            var r = nums.lastIndex
            while(l < r) {
                val sum = a + nums[l] + nums[r]
                when {
                    sum > 0 -> r--
                    sum < 0 -> l++
                    else -> {
                        result.add(listOf(a, nums[l], nums[r]))
                        r--
                        l++
                        // Skip duplicates
                        while(l < r && nums[l] == nums[l - 1]) {
                            l++
                        }
                    }
                }
            }
        }

        return result
    }
}
