class Solution {
   public:
    vector<vector<int>> cache;

    int minCost(vector<vector<int>>& costs) {
        cache.assign(costs.size(), vector<int>(3, -1));
        return dfs(0, -1, costs);
    }

   private:
    int dfs(int houseIndex, int prevColor, vector<vector<int>>& costs) {
        if (houseIndex == costs.size()) {
            return 0;
        }

        if (prevColor != -1 && cache[houseIndex][prevColor] != -1) {
            return cache[houseIndex][prevColor];
        }

        int minCostVal = INT_MAX;
        for (int color = 0; color < 3; color++) {
            if (color == prevColor) {
                continue;
            }
            minCostVal = min(minCostVal, costs[houseIndex][color] + dfs(houseIndex + 1, color, costs));
        }

        if (prevColor != -1) {
            cache[houseIndex][prevColor] = minCostVal;
        }

        return minCostVal;
    }
};