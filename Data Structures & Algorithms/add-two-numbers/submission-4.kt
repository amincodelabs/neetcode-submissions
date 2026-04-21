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
    private fun add(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        if (l1 == null && l2 == null && carry == 0) return null

        val v1 = l1?.`val` ?: 0
        val v2 = l2?.`val` ?: 0
        val sum = v1 + v2 + carry
        val newCarry = sum / 10
        val valNode = sum % 10

        val nextNode = add(l1?.next, l2?.next, newCarry)
        return ListNode(valNode).apply { next = nextNode }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return add(l1, l2, 0)
    }
}