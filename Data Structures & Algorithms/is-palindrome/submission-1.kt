class Solution {
    fun isPalindrome(s: String): Boolean {
        var cleanString = ""
        for(c in s) {
            if(c.isLetterOrDigit())
                cleanString += c.lowercaseChar()
        }

        return cleanString == cleanString.reversed()
    }
}
