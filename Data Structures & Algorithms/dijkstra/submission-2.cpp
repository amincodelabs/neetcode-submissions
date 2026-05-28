/*
    Algorithm:
    
    1. Create adjacancy list of node : list of [neighbor, weight]
    2. Initialize nodes with empty list
    3. Build directed graph from the edges
    4. Create shortes map of {node, distance form src}
    5. Create min-heap and start with src
    6. While heap != empty keep popping, add them into the shortest map if already not there, iterate through popped node's
       neighbors and push them into the heap.
    7. Fill the missing nodes
*/
class Solution {
public:
    unordered_map<int, int> shortestPath(int n, vector<vector<int>>& edges, int src) {
        // adj[node] = list of {neighbor, edgeWeight}
        unordered_map<int, vector<pair<int, int>>> adj;

        // Initialize nodes from 0 to n - 1
        for (int i = 0; i < n; i++) {
            adj[i] = {};
        }

        // Build directed graph
        for (const vector<int>& edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            adj[from].push_back({to, weight});
        }

        // shortest[node] = finalized shortest distance from src
        unordered_map<int, int> shortest;

        // Min heap stores {distanceFromSrc, node}
        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > minHeap;

        minHeap.push({0, src});

        while (!minHeap.empty()) {
            auto [distance, node] = minHeap.top();
            minHeap.pop();

            // If already finalized, ignore duplicate heap entry
            if (shortest.find(node) != shortest.end()) {
                continue;
            }

            // First time we pop a node, this is its shortest distance
            shortest[node] = distance;

            // Try reaching each neighbor through current node
            for (const auto& [neighbor, weight] : adj[node]) {
                if (shortest.find(neighbor) == shortest.end()) {
                    minHeap.push({distance + weight, neighbor});
                }
            }
        }

        // Mark unreachable nodes as -1
        for (int node = 0; node < n; node++) {
            if (shortest.find(node) == shortest.end()) {
                shortest[node] = -1;
            }
        }

        return shortest;
    }
};