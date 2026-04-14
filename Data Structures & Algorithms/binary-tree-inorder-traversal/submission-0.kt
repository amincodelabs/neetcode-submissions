/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inorder(root, {
            result.add(it.`val`)
        })

        return result
    }

    private fun inorder(node: TreeNode?, visit: (TreeNode) -> Unit) {
        if(node == null) {
            return
        }

        inorder(node.left, visit)
        visit(node)
        inorder(node.right, visit)
    }
}
