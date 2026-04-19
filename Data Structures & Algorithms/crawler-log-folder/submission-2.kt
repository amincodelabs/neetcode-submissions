class Solution {
    fun minOperations(logs: Array<String>): Int {
        val stack = ArrayDeque<String>()

        for(log in logs) {
            when(log) {
                "./" -> continue
                "../" -> {
                    if(stack.isNotEmpty()) {
                        stack.removeLast()
                    }
                }
                else -> stack.addLast(log)
            }
        }

        return stack.size
    }
}
