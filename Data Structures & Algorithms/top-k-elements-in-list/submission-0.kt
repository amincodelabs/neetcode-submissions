class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()
        val freq = List(nums.size + 1) { mutableListOf<Int>() }

        for(num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }

        for((num, cnt) in count) {
            freq[cnt].add(num)
        }

        val result = mutableListOf<Int>()
        for(i in freq.size - 1 downTo 1) {
            for(num in freq[i]) {
                result.add(num)
                if(result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return result.toIntArray()
    }
}
