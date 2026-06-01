// Kadane's Algorithm - Simpler
// O(n)
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maximum = nums[0];
        int currentSum = 0;

        for(int num : nums) {
            currentSum = max(currentSum, 0);
            currentSum += num;
            maximum = max(currentSum, maximum);
        }

        return maximum;
    }
};
