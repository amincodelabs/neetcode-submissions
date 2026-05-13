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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        return divide(lists, 0, lists.size - 1)
    }

    private fun divide(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
        if (left > right) return null
        if (left == right) return lists[left]

        val mid = left + (right - left) / 2
        val l1 = divide(lists, left, mid)
        val l2 = divide(lists, mid + 1, right)

        return conquer(l1, l2)
    }

    private fun conquer(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var list1 = l1
        var list2 = l2

        while (list1 != null && list2 != null) {
            if (list1.`val` <= list2.`val`) {
                curr.next = list1
                list1 = list1.next
            } else {
                curr.next = list2
                list2 = list2.next
            }
            curr = curr.next!!
        }

        curr.next = list1 ?: list2
        return dummy.next
    }
}