/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    private fun mergeList(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var first = l1
        var second = l2

        while (first != null && second != null) {
            if (first.`val` < second.`val`) {
                tail.next = first
                first = first.next
            } else {
                tail.next = second
                second = second.next
            }
            tail = tail.next!!
        }

        if (first != null) {
            tail.next = first
        }
        if (second != null) {
            tail.next = second
        }

        return dummy.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }

        for (i in 1 until lists.size) {
            lists[i] = mergeList(lists[i-1], lists[i])
        }

        return lists.last()
    }
}