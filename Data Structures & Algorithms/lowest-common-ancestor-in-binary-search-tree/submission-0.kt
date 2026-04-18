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

        while(current != null) {
            val value = current.`val`
            if(p!!.`val` > value && q!!.`val` > value) {
                current = current.right
            } else if(p!!.`val` < value && q!!.`val` < value) {
                current = current.left
            } else {
                return current
            }
        }

        return null
    }
}
