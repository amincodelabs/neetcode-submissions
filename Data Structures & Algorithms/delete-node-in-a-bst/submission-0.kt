/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if(root == null) {
            return null
        }

        if(key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else if(key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else {
            if(root.left == null) {
                return root.right
            } else if(root.right == null) {
                return root.left
            } else {
                val minNode = getMin(root.right)
                root.`val` = minNode.`val`
                root.right = deleteNode(root.right, minNode.`val`)
            }

        }

        return root
    }

    private fun getMin(node: TreeNode?): TreeNode {
        var current = node

        while (current != null && current.left != null) {
            current = current.left
        }

        return current!!
    }
}
