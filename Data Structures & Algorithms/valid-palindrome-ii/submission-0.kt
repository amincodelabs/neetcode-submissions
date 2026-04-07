class Solution {
    fun validPalindrome(s: String): Boolean {
        fun isPalindrome(l: Int, r: Int): Boolean {
            var left = l
            var right = r
            while (left < right) {
                if (s[left] != s[right]) return false
                left++
                right--
            }
            return true
        }

        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) {
                return isPalindrome(l + 1, r) || isPalindrome(l, r - 1)
            }
            l++
            r--
        }

        return true
    }
}