class MyQueue() {
    
    private val stackIn = Stack()
    private val stackOut = Stack()

    fun push(x: Int) {
        stackIn.push(x)
    }

    fun pop(): Int {
        transfer()
        return stackOut.pop()
    }

    fun peek(): Int {
        transfer()
        return stackOut.peek()
    }

    fun empty(): Boolean {
        return stackIn.size == 0 && stackOut.size == 0
    }

    private fun transfer() {
        if (stackOut.size == 0) {
            while (stackIn.size > 0) {
                stackOut.push(stackIn.pop())
            }
        }
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
