// Brute Force
// Qubic(n ^ 3)
class Solution {
    fun longestPalindrome(s: String): String {
        var result = ""

        for(i in s.indices) {
            for(j in i until s.length) {
                var l = i
                var r = j
                while(l < r && s[l] == s[r]) {
                    l++
                    r--
                }
                if(l >= r && result.length < j - i + 1) {
                    result = s.substring(i, j + 1)
                }
            }
        }

        return result
    }
}
