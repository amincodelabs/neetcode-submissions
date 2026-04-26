/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/
// DFS
class Solution {
    fun cloneGraph(node: Node?): Node? {
        node ?: return null

        val map = HashMap<Node, Node>()

        fun dfs(node: Node): Node {
            if(node in map)
                return map[node]!!
            
            val clone = Node(node.`val`)
            map[node] = clone

            for(nei in node.neighbors) {
                nei?.let {
                    clone.neighbors.add(dfs(it))
                }
            }

            return clone
        }

        return dfs(node)
    }
}
