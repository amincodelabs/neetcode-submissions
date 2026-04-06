class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty() || s.length < t.length) return ""

        val need = mutableMapOf<Char, Int>()
        for (c in t) {
            need[c] = need.getOrDefault(c, 0) + 1
        }

        val window = mutableMapOf<Char, Int>()
        val required = need.size
        var formed = 0

        var left = 0
        var minLen = Int.MAX_VALUE
        var minStart = 0

        for (right in s.indices) {
            val c = s[right]
            window[c] = window.getOrDefault(c, 0) + 1

            if (c in need && window[c] == need[c]) {
                formed++
            }

            while (formed == required) {
                val len = right - left + 1
                if (len < minLen) {
                    minLen = len
                    minStart = left
                }

                val leftChar = s[left]
                window[leftChar] = window.getOrDefault(leftChar, 0) - 1

                if (leftChar in need && window[leftChar]!! < need[leftChar]!!) {
                    formed--
                }

                left++
            }
        }

        return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLen)
    }
}