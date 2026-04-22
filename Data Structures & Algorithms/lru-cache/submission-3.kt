// Cleaner
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
        val node = cache[key] ?: return -1
        remove(node)
        insert(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let { remove(it) }
        
        val node = Node(key, value)
        cache[key] = node
        insert(node)

        if (cache.size > capacity) {
            val lru = left.next ?: return
            remove(lru)
            cache.remove(lru.key)
        }
    }

    private fun insert(node: Node) {
        val prev = right.prev
        prev?.next = node
        node.prev = prev
        node.next = right
        right.prev = node
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