class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val nodes = mutableListOf<Int>()

        for (list in lists) {
            var curr = list
            while (curr != null) {
                nodes.add(curr.`val`)
                curr = curr.next
            }
        }

        nodes.sort()

        val dummy = ListNode(0)
        var curr = dummy

        for (value in nodes) {
            curr.next = ListNode(value)
            curr = curr.next!!
        }

        return dummy.next
    }
}