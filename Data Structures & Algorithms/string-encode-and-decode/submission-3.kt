class Solution {

    fun encode(strs: List<String>): String {
        val result = StringBuilder()

        for (str in strs) {
            result.append(str.length)
            result.append('#')
            result.append(str)
        }

        return result.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < str.length) {
            var j = i

            while (str[j] != '#') {
                j++
            }

            val length = str.substring(i, j).toInt()
            val valueStart = j + 1
            val valueEnd = valueStart + length

            result.add(str.substring(valueStart, valueEnd))
            i = valueEnd
        }

        return result
    }
}