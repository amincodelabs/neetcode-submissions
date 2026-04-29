class Solution {
    fun climbStairs(n: Int): Int {
        val cache = IntArray(n + 1) { -1 }

        fun recursive(k: Int): Int {
        if(k > n) return 0
        if(k == n) return 1
        if(cache[k] != -1) return cache[k]

        cache[k] = recursive(k + 1) + recursive(k + 2)
        return cache[k]
    }
        val r = recursive(0)
        cache.forEachIndexed {v, i -> print("$v: $i, ")}

        return r
    }
}
