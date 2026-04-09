class Solution {
    fun lengthOfLastWord(s: String): Int {
        var r = s.length - 1
        while(r >= 0 && s[r] == ' ') {
            r--
        }
        
        var c = 0
        while(r >= 0 && s[r] != ' ') {
            c++
            r--
        }

        return c
    }
}