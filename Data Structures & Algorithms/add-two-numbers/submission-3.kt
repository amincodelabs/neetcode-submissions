/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var list1 = l1
        var list2 = l2
        var carry = 0

        while(list1 != null || list2 != null || carry != 0) {
            val value1 = list1?.`val` ?: 0
            val value2 = list2?.`val` ?: 0
            
            val sum = value1 + value2 + carry
            carry = (sum / 10) % 10
            current.next = ListNode(sum % 10)
           
            list1 = list1?.next
            list2 = list2?.next
            current = current.next!!
        }

        return dummy.next
    }
}
