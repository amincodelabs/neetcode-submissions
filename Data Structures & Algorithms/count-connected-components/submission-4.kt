class DSU(n: Int) {
    val parent = IntArray(n) { it }
    val rank = IntArray(n) { 1 }

    fun find(node: Int): Int {
        var cur = node
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]]
            cur = parent[cur]
        }
        return cur
    }

    fun union(u: Int, v: Int): Boolean {
        val pu = find(u)
        val pv = find(v)
        if (pu == pv) {
            return false
        }
        if (rank[pv] > rank[pu]) {
            parent[pu] = pv
        } else {
            parent[pv] = pu
            rank[pu] += rank[pv]
        }
        return true
    }
}
// Disjoint Set Union (Rank | Size)
class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val dsu = DSU(n)
        var res = n
        for (edge in edges) {
            val (u, v) = edge
            if (dsu.union(u, v)) {
                res--
            }
        }
        return res
    }
}