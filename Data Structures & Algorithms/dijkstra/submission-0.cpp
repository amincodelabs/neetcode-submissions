class Solution {
   public:
    unordered_map<int, int> shortestPath(int n, vector<vector<int>>& edges, int src) {
        // Build adjacency list
        // node : [(d, w), (d, w), (d, w)]
        unordered_map<int, vector<pair<int, int>>> adj;
        for (int i = 1; i <= n + 1; i++) {
            adj[i] = vector<pair<int, int>>();
        }

        for (vector<int>& edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            adj[source].push_back({destination, weight});
        }

        // Compute shortest paths
        // {node : cost}
        unordered_map<int, int> shortest;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        minHeap.push({0, src});

        while(!minHeap.empty()) {
            pair<int, int> current = minHeap.top();
            minHeap.pop();
            int w1 = current.first, n1 = current.second;

            if(shortest.find(n1) != shortest.end()) {
                continue;
            }
            shortest[n1] = w1;

            for(pair<int, int>& edge : adj[n1]) {
                int n2 = edge.first, w2 = edge.second;
                if(shortest.find(n2) == shortest.end()) {
                    minHeap.push({w1 + w2, n2});
                }
            }
        }

        // Fill in missing nodes
        for(int i = 0; i < n; i++) {
            if(shortest.find(i) == shortest.end()) {
                shortest[i] = -1;
            }
        }

        return shortest;

    }
};
