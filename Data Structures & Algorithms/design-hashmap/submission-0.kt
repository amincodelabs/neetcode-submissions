class ListNode(var key: Int = -1, var `val`: Int = -1, var next: ListNode? = null)

class MyHashMap() {
    private val map = Array(1000) { ListNode() }

    private fun hash(key: Int): Int = key % map.size

    fun put(key: Int, value: Int) {
        var cur = map[hash(key)]
        while (cur.next != null) {
            if (cur.next!!.key == key) {
                cur.next!!.`val` = value
                return
            }
            cur = cur.next!!
        }
        cur.next = ListNode(key, value)
    }

    fun get(key: Int): Int {
        var cur = map[hash(key)].next
        while (cur != null) {
            if (cur.key == key) {
                return cur.`val`
            }
            cur = cur.next
        }
        return -1
    }

    fun remove(key: Int) {
        var cur = map[hash(key)]
        while (cur.next != null) {
            if (cur.next!!.key == key) {
                cur.next = cur.next!!.next
                return
            }
            cur = cur.next!!
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
