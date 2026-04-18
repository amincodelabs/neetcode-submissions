/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun validate(node: TreeNode?, left: Long, right: Long): Boolean {
        node ?: return true

        val value = node.`val`.toLong()
        if (value <= left || value >= right) {
            return false
        }

        return validate(node.left, left, value) && validate(node.right, value, right)
    }
}