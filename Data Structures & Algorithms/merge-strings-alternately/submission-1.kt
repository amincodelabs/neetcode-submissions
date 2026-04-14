class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        return buildString {
            val maxLength = maxOf(word1.length, word2.length)
            for (i in 0 until maxLength) {
                if (i < word1.length) append(word1[i])
                if (i < word2.length) append(word2[i])
            }
        }
    }
}