class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var a = 0
        var b = 0
        var result = ""

        while(a < word1.length && b < word2.length) {
            result += word1[a++]
            result += word2[b++]
        }

        result += word1.substring(a, word1.length)
        result += word2.substring(b, word2.length)

        return result
    }
}
