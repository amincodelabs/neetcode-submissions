/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()

        stack.addLast(root)

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            result.add(node.`val`)

            // Notice: push left first, then right
            node.left?.let { stack.addLast(it) }
            node.right?.let { stack.addLast(it) }
        }

        return result.reversed()
    }
}