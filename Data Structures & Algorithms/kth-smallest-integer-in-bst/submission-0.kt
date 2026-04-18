/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            node ?: return
            dfs(node.left)
            list.add(node.`val`)
            dfs(node.right)
        }

        dfs(root)
        return list[k - 1]
    }
}