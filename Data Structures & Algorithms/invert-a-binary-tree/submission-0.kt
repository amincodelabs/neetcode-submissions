/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        fun preorder(node: TreeNode?) {
            node ?: return

            val temp = node.left
            node.left = node.right
            node.right = temp
            preorder(node.left)
            preorder(node.right)
        }

        preorder(root)
        return root
    }
}
