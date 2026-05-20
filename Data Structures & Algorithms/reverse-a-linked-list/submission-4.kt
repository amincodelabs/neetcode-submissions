/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {

        fun reverse(node: ListNode?, prev: ListNode?): ListNode? {
            if(node == null) {
                return prev
            }

            val next = node.next
            node.next = prev

            return reverse(next, node)
        }

        return reverse(head, null)
    }
}
