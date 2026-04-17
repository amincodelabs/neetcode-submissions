/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }

        val q = ArrayDeque<TreeNode>()
        var level = 0
        q.addLast(root)

        while(q.isNotEmpty()) {
            val size = q.size

            repeat(size) {
                val node = q.removeFirst()
                node.left?.let { q.addLast(it) }
                node.right?.let { q.addLast(it) }
            }
            
            level++
        }

        return level
    }
}
