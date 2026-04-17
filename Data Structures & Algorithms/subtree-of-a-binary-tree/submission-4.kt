/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    private fun serialize(node: TreeNode?): String {
        if (node == null) return "#"

        return buildString {
            append("$")
            append(node.`val`)
            append(serialize(node.left))
            append(serialize(node.right))
        }
    }

    private fun buildZArray(text: String): IntArray {
        val z = IntArray(text.length)
        var left = 0
        var right = 0

        for (i in 1 until text.length) {
            if (i <= right) {
                z[i] = minOf(right - i + 1, z[i - left])
            }

            while (i + z[i] < text.length && text[z[i]] == text[i + z[i]]) {
                z[i]++
            }

            if (i + z[i] - 1 > right) {
                left = i
                right = i + z[i] - 1
            }
        }

        return z
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        val rootSerialized = serialize(root)
        val subRootSerialized = serialize(subRoot)

        val combined = "$subRootSerialized|$rootSerialized"
        val z = buildZArray(combined)
        val patternLength = subRootSerialized.length

        for (i in patternLength + 1 until combined.length) {
            if (z[i] == patternLength) {
                return true
            }
        }

        return false
    }
}