class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0
        
        for(i in s.indices) {
            if(i > 0) {
                score += abs(s[i] - s[i - 1])
            } 
        }

        return score
    }
}
