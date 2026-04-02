class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for(str in strs) {
            val count = IntArray(26)

            for(ch in str) {
                count[ch - 'a']++
            }

            val key = buildString {
                for(i in 0 until 26) {
                    append('#')
                    append(count[i])
                }
            }

            map.getOrPut(key) { mutableListOf() }.add(str)
        }

        return map.values.toList()
    }
}
