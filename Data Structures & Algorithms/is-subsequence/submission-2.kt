class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while(j < t.length && i < s.length) {
            if(t[j] == s[i]) {
                i++
            }
            j++
        }

        return i >= s.length
    }
}
