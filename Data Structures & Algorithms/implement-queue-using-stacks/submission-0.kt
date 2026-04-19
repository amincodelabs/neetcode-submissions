class MyQueue() {

    private val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addLast(x)
    }

    fun pop(): Int {
        return stack.removeFirst()
    }

    fun peek(): Int {
        return stack.first()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * val obj = MyQueue()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.peek()
 * val param_4 = obj.empty()
 */
