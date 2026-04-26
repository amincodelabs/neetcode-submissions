/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val oldToNew = HashMap<Node, Node>()
        oldToNew[node] = Node(node.`val`)
        val queue = ArrayDeque<Node>()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            for (nei in cur.neighbors) {
                nei?.let { neighbor ->
                    if (neighbor !in oldToNew) {
                        oldToNew[neighbor] = Node(neighbor.`val`)
                        queue.add(neighbor)
                    }
                    oldToNew[cur]?.neighbors?.add(oldToNew[neighbor])
                }
            }
        }

        return oldToNew[node]
    }
}