class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false

        val graph = Array(n) { mutableListOf<Int>() }

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        val visited = BooleanArray(n)

        fun hasCycle(node: Int, parent: Int): Boolean {
            if (visited[node]) return true

            visited[node] = true

            for (neighbor in graph[node]) {
                if (neighbor == parent) continue
                if (hasCycle(neighbor, node)) return true
            }

            return false
        }

        if (hasCycle(0, -1)) return false

        return visited.all { it }
    }
}