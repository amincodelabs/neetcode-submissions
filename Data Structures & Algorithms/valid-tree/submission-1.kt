class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size > n - 1) return false

        val adj = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }

        val visit = HashSet<Int>()

        fun dfs(node: Int, parent: Int): Boolean {
            if (node in visit) return false
            visit.add(node)
            for (nei in adj[node]) {
                if (nei == parent) continue
                if (!dfs(nei, node)) return false
            }
            return true
        }

        return dfs(0, -1) && visit.size == n
    }
}