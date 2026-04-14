class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var write = m + n - 1
        var a = m - 1
        var b = n - 1

        while(b >= 0) {
            if(a >= 0 && nums1[a] > nums2[b]) {
                nums1[write--] = nums1[a--]
            } else {
                nums1[write--] = nums2[b--]
            }
        }
    }
}