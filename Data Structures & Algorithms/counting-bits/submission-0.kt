class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)
        for (i in 0..n) {
            var count = 0
            var num = i
            while (num > 0) {
                count += num and 1  // Add 1 if last bit is 1
                num = num shr 1     // Shift right to check next bit
            }
            result[i] = count
        }
        return result
    }
}