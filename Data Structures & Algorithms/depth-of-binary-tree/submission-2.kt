/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val stack = ArrayDeque<Pair<TreeNode?, Int>>()
        stack.addLast(Pair(root, 1))
        var res = 0

        while (stack.isNotEmpty()) {
            val (node, depth) = stack.removeLast()

            if (node != null) {
                res = maxOf(res, depth)
                stack.addLast(Pair(node.left, depth + 1))
                stack.addLast(Pair(node.right, depth + 1))
            }
        }

        return res
    }
}