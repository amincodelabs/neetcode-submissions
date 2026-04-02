/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        // 1) Find end of first half
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // 2) Split and reverse second half
        var current = slow?.next
        slow?.next = null

        var prev: ListNode? = null
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        // 3) Merge
        var p1 = head
        var p2 = prev

        while (p2 != null) {
            val temp1 = p1?.next
            val temp2 = p2.next

            p1?.next = p2
            p2.next = temp1

            p1 = temp1
            p2 = temp2
        }
    }
}





