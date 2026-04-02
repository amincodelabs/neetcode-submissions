class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        var sum = 0
        
        for (op in operations) {
            when (op) {
                "+" -> {
                    val last = stack.removeLast()
                    val newScore = last + stack.last()
                    stack.addLast(last)
                    stack.addLast(newScore)
                    sum += newScore
                }
                "D" -> {
                    val newScore = stack.last() * 2
                    stack.addLast(newScore)
                    sum += newScore
                }
                "C" -> {
                    val last = stack.last()
                    stack.removeLast()
                    sum -= last
                }
                else -> {
                    val newScore = op.toInt()
                    stack.addLast(newScore)
                    sum += newScore
                }
            }
        }
        
        return sum
    }
}