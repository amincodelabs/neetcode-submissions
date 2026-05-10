# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Reverse And Merge
# O(n) time, O(1) space
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # Find middle
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second portion
        second = slow.next
        prev = slow.next = None
        while second:
            next = second.next
            second.next = prev
            prev = second
            second = next
        
        # Merge two halves
        first, second = head, prev
        while second:
            temp1, temp2 = first.next, second. next
            first.next = second
            second.next = temp1
            first, second = temp1, temp2





