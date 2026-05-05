class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = HashMap<Int, Int>()
        for(num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        for((num, freq)in freqMap) {
            heap.add(freq to num)
            if(heap.size > k) {
                heap.poll()
            }
        }

        val result = IntArray(k)
        for(i in k - 1 downTo 0) {
            result[i] = heap.poll().second
        }

        return result
    }
}
