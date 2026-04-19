class Solution {
    fun minOperations(logs: Array<String>): Int {
        var ops = 0
        for(log in logs) {
            when(log) {
                "./" -> continue
                "../" -> ops = maxOf(ops - 1, 0)
                else -> ops++
            }
        }

        return ops
    }
}
