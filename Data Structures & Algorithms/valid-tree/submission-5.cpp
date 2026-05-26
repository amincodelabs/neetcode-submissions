// Cycle Detection (DFS)
class Solution {
   public:
    bool validTree(int n, vector<vector<int>>& edges) {
        // A valid tree with n nodes has exactly n - 1 edges
        if (edges.size() != n - 1) {
            return false;
        }

        vector<vector<int>> graph(n);
        for (const auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }

        unordered_set<int> visited;
        if (!dfs(0, -1, visited, graph)) {
            return false;
        }

        return visited.size() == n;
    }

   private:
    bool dfs(int node, int parent, unordered_set<int>& visited, const vector<vector<int>>& graph) {
        // A valid tree must not have a cycle in it
        if (visited.count(node)) {
            return false;
        }

        visited.insert(node);
        for (int nei : graph[node]) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(nei, node, visited, graph)) {
                return false;
            }
        }

        return true;
    }
};
