# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# T O(n), M O(n)
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        def reverse(node: Optional[ListNode], prev: Optional[ListNode]) -> Optional[ListNode] :
            if not node:
                return prev
            
            next_node = node.next
            node.next = prev

            return reverse(next_node, node)
        return reverse(head, None)