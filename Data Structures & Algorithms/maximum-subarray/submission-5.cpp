// Kadane's Algorithm
// O(n)
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maximum = nums[0];
        int currentSum = 0;

        for(int num : nums) {
            if(currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maximum = max(currentSum, maximum);
        }

        return maximum;
    }
};
