class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var left: ListNode? = dummy
        var right = head
        
        // Move right pointer n steps ahead
        for (i in 0 until n) {
            right = right?.next
        }
        
        // Move both pointers until right reaches the end
        while (right != null) {
            left = left?.next
            right = right.next
        }
        
        // Remove the node
        left?.next = left?.next?.next
        return dummy.next
    }
}