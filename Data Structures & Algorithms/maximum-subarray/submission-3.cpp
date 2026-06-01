// Brute Force
// Cubic (n^2)
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int maximum = nums[0];
        for(int i = 0; i < n; i++) {
            int currentSum = 0;
            for(int j = i; j < n; j++) {
                currentSum += nums[j];
                maximum = max(currentSum, maximum);
            }
        }

        return maximum;
    }
};
