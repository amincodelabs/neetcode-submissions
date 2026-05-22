class Solution:
    def isValidBST(self, root: Optional[TreeNode], min_val=float('-inf'), max_val=float('inf')) -> bool:
        if root is None:
            return True
        if not (min_val < root.val < max_val):
            return False
        return self.isValidBST(root.left, min_val, root.val) and self.isValidBST(root.right, root.val, max_val)