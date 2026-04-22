// Doubly LinkedList
// T: O(1)
// S: O(n)
class LRUCache(capacity: Int) {

    private val capacity = capacity
    private val cache = mutableMapOf<Int, Node>()
    private val left = Node(0, 0)
    private val right = Node(0, 0)

    init {
        left.next = right
        right.prev = left
    }

    fun get(key: Int): Int {
        return cache[key]?.let {
            remove(it)
            insert(it)
            it.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let { node ->
            remove(node)
            cache.remove(key)
        }

        val node = Node(key, value)
        cache[key] = node
        insert(node)

        if (cache.size > capacity) {
            left.next?.let { lru ->
                remove(lru)
                cache.remove(lru.key)
            }
        }
    }

    private fun insert(node: Node) {
        val prev = right.prev
        val next = right
        prev?.next = node
        next.prev = node
        node.prev = prev
        node.next = next
    }

    private fun remove(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }

    data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}
