# BFS
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None

        queue = deque([root])
        while queue:
            node = queue.popleft()
            temp = node.left
            node.left = node.right
            node.right = temp
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
        
        return root
