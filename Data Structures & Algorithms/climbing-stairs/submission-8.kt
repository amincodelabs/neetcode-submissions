class Solution {
    fun climbStairs(n: Int): Int {
        if(n <= 2) return n
        
        val cache = IntArray(n + 1)
        cache[1] = 1
        cache[2] = 2

        for(i in 3..n) {
            cache[i] = cache[i - 1] + cache[i - 2]
        }

        return cache[n]
    }
}
