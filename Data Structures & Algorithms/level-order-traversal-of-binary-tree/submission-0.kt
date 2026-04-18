/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        val q = ArrayDeque<TreeNode>()
        val result = mutableListOf<MutableList<Int>>()

        q.addLast(root)

        while(q.isNotEmpty()) {
            val level = mutableListOf<Int>()
            val size = q.size

            repeat(size) {
                val node = q.removeFirst()
                level.add(node.`val`)
                node.left?.let { q.addLast(it) }
                node.right?.let { q.addLast(it) }
            }
            result.add(level)
        }

        return result
    }
}
