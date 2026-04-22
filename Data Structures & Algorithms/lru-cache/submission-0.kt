class LRUCache(capacity: Int) {

    private val capacity = capacity
    private val cache = MyLinkedHashMap(capacity)

    fun get(key: Int): Int {
        return cache.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        cache[key] = value
    }

    class MyLinkedHashMap(private val capacity: Int): LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>): Boolean {
            return size > capacity
        }
    }
}
