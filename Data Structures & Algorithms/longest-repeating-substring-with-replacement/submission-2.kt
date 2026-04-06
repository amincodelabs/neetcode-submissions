class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var res = 0
        val charSet = s.toSet()

        for (c in charSet) {
            var count = 0
            var l = 0
            for (r in s.indices) {
                if (s[r] == c) {
                    count++
                }

                while ((r - l + 1) - count > k) {
                    if (s[l] == c) {
                        count--
                    }
                    l++
                }

                res = maxOf(res, r - l + 1)
            }
        }

        return res
    }
}