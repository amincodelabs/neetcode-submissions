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

    private fun validate(root: TreeNode?, min: Long, max: Long): Boolean {
        root ?: return true

        if (root.`val` <= min || root.`val` >= max) {
            return false
        }

        return validate(root.left, min, root.`val`.toLong()) && validate(root.right, root.`val`.toLong(), max)
        return isValidBST(root.left) && isValidBST(root.right)
    }
}