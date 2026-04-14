class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var write = m + n - 1
        var a = m - 1
        var b = n - 1

        while(a >= 0 && b >= 0) {
            if(nums1[a] > nums2[b]) {
                nums1[write] = nums1[a]
                a--
            } else {
                nums1[write] = nums2[b]
                b--
            }
            write--
        }

        while(a >= 0) {
            nums1[write] = nums1[a]
            a--
            write--
        }

        while(b >= 0) {
            nums1[write] = nums2[b]
            b--
            write--
        }
    }
}
/*
[10,20,10,20,20,40]          [1,2]

a = -1
b = 1
write = 1
*/