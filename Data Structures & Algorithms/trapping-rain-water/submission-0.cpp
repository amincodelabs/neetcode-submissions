class Solution {
   public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> maxLeft(n);
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            maxLeft[i] = currentMax;
            currentMax = std::max(currentMax, height[i]);
        }

        vector<int> maxRight(n);
        currentMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = currentMax;
            currentMax = std::max(currentMax, height[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += std::max(std::min(maxLeft[i], maxRight[i]) - height[i], 0);
        }

        return result;
    }
};
// max left  = [0, 0, 2, 2, 3, 3, 3, 3, 3, 3]
// max right = [3, 3, 3, 3, 3, 3, 3, 2, 1, 0]
// min(L, R) = [0, 0, 2, 2, 3, 3, 3, 2, 1, 0]
// result    = [0, 0, 2, 0, 2, 3, 2, 0, 0, 0]