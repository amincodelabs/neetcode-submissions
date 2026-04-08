class Solution {
    fun myPow(x: Double, n: Int): Double {
        var result: Double = 1.0
        val absN = if (n < 0) -n else n
        for(num in 1..absN) {
            result *= x
        }

        return if (n < 0) 1.0 / result else result
    }
}