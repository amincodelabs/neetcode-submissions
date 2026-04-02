class MyStack() {

    private val q1 = ArrayDeque<Int>()
    private val q2 = ArrayDeque<Int>()

    fun push(x: Int) {
        q1.addLast(x)
    }

    fun pop(): Int {
        while (q1.size > 1) {
            q2.addLast(q1.removeFirst())
        }

        val res = q1.removeFirst()

        // swap q1 and q2
        val temp = q1
        q1.clear()
        q1.addAll(q2)
        q2.clear()

        return res
    }

    fun top(): Int {
        while (q1.size > 1) {
            q2.addLast(q1.removeFirst())
        }

        val res = q1.first()

        q2.addLast(q1.removeFirst())

        // swap
        val temp = q1
        q1.clear()
        q1.addAll(q2)
        q2.clear()

        return res
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
