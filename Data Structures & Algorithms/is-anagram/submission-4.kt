class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        
        val array = IntArray(26)
        for(c in s) {
            array[c - 'a']++
        }
        for(c in t) {
            array[c - 'a']--
        }

        for(e in array) {
            if(e > 0) return false
        }
        return true
    }
}
