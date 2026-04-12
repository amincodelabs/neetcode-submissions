class Solution {
    fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
        val mapping = IntArray(nums1.size)

        for(i in nums1.indices) {
            for(j in nums2.indices) {
                if(nums1[i] == nums2[j]) {
                    mapping[i] = j
                }
            }
        }

        return mapping
    }
}
