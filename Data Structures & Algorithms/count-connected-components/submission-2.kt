class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        val visit = BooleanArray(n)
        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }

        fun bfs(node: Int) {
            val q: Queue<Int> = LinkedList()
            q.offer(node)
            visit[node] = true
            while (q.isNotEmpty()) {
                val cur = q.poll()
                for (nei in adj[cur]) {
                    if (!visit[nei]) {
                        visit[nei] = true
                        q.offer(nei)
                    }
                }
            }
        }

        var res = 0
        for (node in 0 until n) {
            if (!visit[node]) {
                bfs(node)
                res++
            }
        }
        return res
    }
}