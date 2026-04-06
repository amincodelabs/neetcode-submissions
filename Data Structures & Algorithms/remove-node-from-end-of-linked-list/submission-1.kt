/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var current = head
        var size = 0
        while(current != null) {
            size++
            current = current.next
        }
        
        val index = size - n
        val dummy = ListNode(-1)
        dummy.next = head
        var prev: ListNode? = dummy
        current = dummy.next
        var c = -1
        while(c < index - 1) {
            prev = current
            current = current?.next
            c++
        }

        prev?.next = current?.next

        return dummy.next
    }
}

