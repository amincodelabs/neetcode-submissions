class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int, int>>> adj(n + 1);

        for (const auto& time : times) {
            int u = time[0], v = time[1], w = time[2];
            adj[u].push_back({v, w});
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        minHeap.push({0, k});

        vector<int> shortest(n + 1, -1);
        int ans = 0;

        while (!minHeap.empty()) {
            auto [weight, node] = minHeap.top();
            minHeap.pop();

            if (shortest[node] != -1) continue;

            shortest[node] = weight;
            ans = max(ans, weight);

            for (const auto& [nei, w] : adj[node]) {
                if (shortest[nei] == -1) {
                    minHeap.push({weight + w, nei});
                }
            }
        }

        for (int node = 1; node <= n; node++) {
            if (shortest[node] == -1) return -1;
        }

        return ans;
    }
};