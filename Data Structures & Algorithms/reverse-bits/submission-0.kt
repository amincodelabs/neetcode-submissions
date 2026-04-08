class Solution {
    fun reverseBits(n: Int): Int {
        var res = 0
        for (i in 0 until 32) {
            // Extract the bit at position i
            val bit = (n shr i) and 1
            // Place it at position (31 - i) in the result
            res += (bit shl (31 - i))
        }
        return res
    }
}