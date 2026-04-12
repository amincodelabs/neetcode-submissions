class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) {
            return false
        }

        val count = IntArray(26)

        for(i in s.indices) {
            count[s[i] - 'a']++
            count[t[i] - 'a']--
        }

        for(c in count) {
            if(c != 0) {
                return false
            }
        }

        return true
    }
}
