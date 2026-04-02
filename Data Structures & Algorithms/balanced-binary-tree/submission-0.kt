/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return check(root).balanced
    }

    private fun check(node: TreeNode?): Result {
        if(node == null)
            return Result(0, true)

        val left = check(node.left)
        val right = check(node.right)

        val balanced = left.balanced &&
                        right.balanced &&
                        kotlin.math.abs(left.height - right.height) <= 1

        val height = 1 + maxOf(left.height, right.height)

        return Result(height, balanced)
    }
}

data class Result(val height: Int, val balanced: Boolean)
