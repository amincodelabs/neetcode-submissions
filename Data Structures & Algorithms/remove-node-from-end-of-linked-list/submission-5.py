# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Reverse
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        prev, current = None, head
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next

        if n == 1:
            prev = prev.next
        else:
            count = 1
            current = prev
            while count < n - 1:
                current = current.next
                count += 1
            current.next = current.next.next

        current = prev
        prev = None
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next

        return prev


