class Solution {
    fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
        val mapping = IntArray(nums1.size)
        val map = HashMap<Int, Int>()

        for(i in nums2.indices) {
            map[nums2[i]] = i
        }

        for(i in nums1.indices) {
            mapping[i] = map[nums1[i]]!!
        }

        return mapping
    }
}
