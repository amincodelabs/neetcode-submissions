class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var i = 0 // pointer to s
        var j = 0 // pointer to t

        while(i < s.length && j < t.length) {
            if(s[i] == t[j]) {
                j++
            }
            i++
        }

        return t.length - j
    }
}
