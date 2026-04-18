/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var current = root
        val pVal = p!!.`val`
        val qVal = q!!.`val`

        while (current != null) {
            when {
                pVal > current.`val` && qVal > current.`val` -> current = current.right
                pVal < current.`val` && qVal < current.`val` -> current = current.left
                else -> return current
            }
        }

        return null
    }
}
