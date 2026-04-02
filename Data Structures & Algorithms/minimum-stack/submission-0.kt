class MinStack {

    private val data = ArrayDeque<Int>()
    private val mins = ArrayDeque<Int>()

    fun push(value: Int) {
        data.addLast(value)

        if (mins.isEmpty() || value <= mins.last()) {
            mins.addLast(value)
        }
    }

    fun pop() {
        val removed = data.removeLast()

        if (removed == mins.last()) {
            mins.removeLast()
        }
    }

    fun top(): Int {
        return data.last()
    }

    fun getMin(): Int {
        return mins.last()
    }
}