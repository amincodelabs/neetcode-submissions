class Solution {
   public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegree(n + 1, 0);
        vector<int> outdegree(n + 1, 0);

        for (auto& edge : trust) {
            int from = edge[0];
            int to = edge[1];

            outdegree[from]++;
            indegree[to]++;
        }

        for (int node = 1; node <= n; node++) {
            if (indegree[node] == n - 1 && outdegree[node] == 0) {
                return node;
            }
        }

        return -1;
    }
};