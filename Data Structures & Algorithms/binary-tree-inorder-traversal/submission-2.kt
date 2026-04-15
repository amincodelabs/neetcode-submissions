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
        val stack = ArrayDeque<TreeNode>()
        var current = root

        while (current != null || stack.isNotEmpty()) {

            // Go all the way left
            while (current != null) {
                stack.addLast(current)
                current = current.left
            }

            // Process node
            current = stack.removeLast()
            result.add(current.`val`)

            // Move to right subtree
            current = current.right
        }

        return result
    }
}
