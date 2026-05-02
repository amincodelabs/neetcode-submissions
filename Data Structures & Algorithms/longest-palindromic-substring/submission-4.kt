class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        val n = s.length
        val isPalindrome = Array(n) { BooleanArray(n) }
        
        var start = 0
        var maxLen = 0

        // Iterate backwards for 'i' to ensure sub-problems (i+1, j-1) are solved first
        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                val charactersMatch = s[i] == s[j]
                val isShort = j - i <= 2
                
                if (charactersMatch && (isShort || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true
                    
                    val currentLen = j - i + 1
                    if (currentLen > maxLen) {
                        maxLen = currentLen
                        start = i
                    }
                }
            }
        }

        return s.substring(start, start + maxLen)
    }
}