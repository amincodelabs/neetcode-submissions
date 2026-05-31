class Solution {
   public:
    int minimumSpanningTree(vector<vector<int>>& edges, int n) {
        unordered_map <int, vector<pair<int, int>>> adj;
        for (int i = 0; i < n; i++) {
            adj[i] = {};
        }
        for (auto& edge : edges) {
            int n1 = edge[0], n2 = edge[1], w = edge[2];
            adj[n1].push_back({n2, w});
            adj[n2].push_back({n1, w});
        }

        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>,
                       greater<tuple<int, int, int>>>
            minHeap;
        for (auto& nei : adj[0]) {
            int node = nei.first, w = nei.second;
            minHeap.push({w, 0, node});
        }

        int totalWeight = 0;
        unordered_set<int> visited;
        visited.insert(0);
        while (visited.size() < n && !minHeap.empty()) {
            tuple<int, int, int> current = minHeap.top();
            minHeap.pop();
            int w1 = std::get<0>(current), n1 = std::get<1>(current), n2 = std::get<2>(current);
            if(visited.find(n2) != visited.end()) {
                continue;
            }
            totalWeight += w1;
            visited.insert(n2);
            for(auto &pair : adj[n2]) {
                int nei = pair.first, weight = pair.second;
                if(visited.find(nei) == visited.end()) {
                    minHeap.push({weight, n2, nei});
                }
            }
        }

        return visited.size() == n ? totalWeight : -1;
    }
};
