class Solution {
public:
    int minimumSpanningTree(vector<vector<int>>& edges, int n) {
        vector<vector<pair<int, int>>> adj(n);

        for (const auto& edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }

        using State = tuple<int, int, int>; // {weight, from, to}
        priority_queue<State, vector<State>, greater<State>> minHeap;

        vector<bool> visited(n, false);
        visited[0] = true;

        for (const auto& [nei, w] : adj[0]) {
            minHeap.push({w, 0, nei});
        }

        int totalWeight = 0;
        int nodesVisited = 1;

        while (!minHeap.empty() && nodesVisited < n) {
            auto [w, from, to] = minHeap.top();
            minHeap.pop();

            if (visited[to]) continue;

            visited[to] = true;
            totalWeight += w;
            nodesVisited++;

            for (const auto& [nei, nextW] : adj[to]) {
                if (!visited[nei]) {
                    minHeap.push({nextW, to, nei});
                }
            }
        }

        return nodesVisited == n ? totalWeight : -1;
    }
};