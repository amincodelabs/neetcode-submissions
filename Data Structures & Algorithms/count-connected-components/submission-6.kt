// Depth First Search
class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Int>() }
        val visited = BooleanArray(n)

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        fun dfs(node: Int) {
            for (neighbor in graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    dfs(neighbor)
                }
            }
        }

        var result = 0
        for (node in 0 until n) {
            if (!visited[node]) {
                visited[node] = true
                dfs(node)
                result++
            }
        }
        return result
    }
}