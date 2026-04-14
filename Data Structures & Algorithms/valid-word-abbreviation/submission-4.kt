class Solution {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var wordIndex = 0
        var abbrIndex = 0
        
        while (wordIndex < word.length && abbrIndex < abbr.length) {
            if (abbr[abbrIndex].isDigit()) {
                // Check for leading zero
                if (abbr[abbrIndex] == '0') return false
                
                // Parse the number
                var skipCount = 0
                while (abbrIndex < abbr.length && abbr[abbrIndex].isDigit()) {
                    skipCount = skipCount * 10 + (abbr[abbrIndex] - '0')
                    abbrIndex++
                }
                
                // Skip characters in word
                wordIndex += skipCount
            } else {
                // Compare characters
                if (word[wordIndex] != abbr[abbrIndex]) return false
                wordIndex++
                abbrIndex++
            }
        }
        
        return wordIndex == word.length && abbrIndex == abbr.length
    }
}