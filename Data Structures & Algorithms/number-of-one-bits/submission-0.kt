class Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var num = n
        while (num > 0) {
            count += num and 1  // Add 1 if last bit is 1
            num = num shr 1     // Shift right to check next bit
        }

        return count
    }
}
