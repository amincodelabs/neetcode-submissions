/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return dfs(root, Int.MIN_VALUE)
    }

    private fun dfs(node: TreeNode?, maxValue: Int): Int {
        if(node == null) {
            return 0
        }

        var result = if(node.`val` >= maxValue) 1 else 0
        val max = maxOf(maxValue, node.`val`)

        result += dfs(node.left, max)
        result += dfs(node.right, max)

        return result
    }
}
