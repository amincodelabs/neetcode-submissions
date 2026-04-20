class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack()

        fun operands(): Pair<Int, Int> {
            val b = stack.pop().toInt()
            val a = stack.pop().toInt()
            return Pair(a, b)
        }

        for(token in tokens) {
            when(token) {
                "+" -> {
                    val (a, b) = operands()
                    stack.push(a + b)
                }
                "-" -> {
                    val (a, b) = operands()
                    stack.push(a - b)
                }
                "*" -> {
                    val (a, b) = operands()
                    stack.push(a * b)
                }
                "/" -> {
                    val (a, b) = operands()
                    stack.push((a.toDouble() / b).toInt())
                }
                else -> stack.push(token.toInt())
            }
        }

        return stack.pop()
    }

}

class Stack(private val initialCapacity: Int = 10) {

    private var elements = IntArray(initialCapacity)

    var size: Int =0
        private set

    fun push(element: Int) {
        if(size == elements.size) {
            growSize()
        }

        elements[size++] = element 
    }

    fun pop(): Int {
        if(size == 0) throw NoSuchElementException("Stack is empty")
        return elements[--size]
    }

    fun peek(): Int {
        if (size == 0) throw NoSuchElementException("Stack is empty")
        return elements[size - 1]
    }

    private fun growSize() {
        val newCapacity = if(elements.size == 0) 1 else elements.size * 2
        elements = elements.copyOf(newCapacity)
    }
}