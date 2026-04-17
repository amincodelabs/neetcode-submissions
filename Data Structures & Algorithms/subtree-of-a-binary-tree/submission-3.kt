/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private fun serialize(root: TreeNode?): String {
        return when (root) {
            null -> "$#"
            else -> "$${root.`val`}${serialize(root.left)}${serialize(root.right)}"
        }
    }

    private fun zFunction(s: String): IntArray {
        val n = s.length
        val z = IntArray(n)
        var l = 0
        var r = 0

        for (i in 1 until n) {
            if (i <= r) {
                z[i] = minOf(r - i + 1, z[i - l])
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                z[i]++
            }
            if (i + z[i] - 1 > r) {
                l = i
                r = i + z[i] - 1
            }
        }
        return z
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        val serializedRoot = serialize(root)
        val serializedSubRoot = serialize(subRoot)
        val combined = serializedSubRoot + "|" + serializedRoot

        val zValues = zFunction(combined)
        val subLen = serializedSubRoot.length

        return (subLen + 1 until combined.length).any { i -> zValues[i] == subLen }
    }
}