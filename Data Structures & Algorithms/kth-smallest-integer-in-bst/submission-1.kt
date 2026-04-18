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
        val stack = ArrayDeque<TreeNode>()
        var current = root

        while(current != null || stack.isNotEmpty()) {
            // Go all the way left
            while(current != null) {
                stack.addLast(current)
                current = current.left
            }

            // Process node
            current = stack.removeLast()
            list.add(current.`val`)

            // Move to the right subtree
            current = current.right

        }

        return list[k - 1]
    }
}