class Solution {
   public:
    bool canPartition(vector<int>& nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // Odd number cannot be partitioned in two integer halves
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        memo.assign(nums.size(), vector<int>(target + 1, -1));

        return dfs(0, 0, target, nums);
    }

   private:
    vector<vector<int>> memo;

    bool dfs(int index, int currentSum, int target, vector<int>& nums) {
        if (currentSum == target) {
            return true;
        }
        if (currentSum > target) {
            return false;
        }
        if (index == nums.size()) {
            return false;
        }
        if (memo[index][currentSum] != -1) {
            return memo[index][currentSum];
        }

        bool take = dfs(index + 1, currentSum + nums[index], target, nums);
        bool skip = dfs(index + 1, currentSum, target, nums);

        memo[index][currentSum] = take || skip;
        return memo[index][currentSum];
    }
};
