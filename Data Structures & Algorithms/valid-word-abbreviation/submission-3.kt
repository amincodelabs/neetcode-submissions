class Solution {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        val n = word.length
        val m = abbr.length
        var i = 0
        var j = 0

        while (i < n && j < m) {
            if (abbr[j] == '0') return false

            if (abbr[j].isLetter()) {
                if (word[i] == abbr[j]) {
                    i++
                    j++
                } else {
                    return false
                }
            } else {
                var subLen = 0
                while (j < m && abbr[j].isDigit()) {
                    subLen = subLen * 10 + (abbr[j] - '0')
                    j++
                }
                i += subLen
            }
        }

        return i == n && j == m
    }
}