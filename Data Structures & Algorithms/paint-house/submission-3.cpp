class Solution {
   public:
    vector<vector<int>> memo;

    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        memo.assign(n, vector<int>(3, -1));

        // -1 means no color is forbidden for the first house and we have three options
        return findMinCost(0, -1, costs);
    }

   private:
    int findMinCost(int houseIndex, int forbiddenColor, vector<vector<int>>& costs) {
        if (houseIndex == costs.size()) {
            return 0;
        }

        if (forbiddenColor != -1 && memo[houseIndex][forbiddenColor] != -1) {
            return memo[houseIndex][forbiddenColor];
        }

        int minCost = INT_MAX;

        for (int color = 0; color < 3; color++) {
            if (color == forbiddenColor) {
                continue;
            }

            int currentCost = costs[houseIndex][color];
            int remainingCost = findMinCost(houseIndex + 1, color, costs);
            minCost = min(minCost, currentCost + remainingCost);
        }

        if (forbiddenColor != -1) {
            memo[houseIndex][forbiddenColor] = minCost;
        }

        return minCost;
    }
};