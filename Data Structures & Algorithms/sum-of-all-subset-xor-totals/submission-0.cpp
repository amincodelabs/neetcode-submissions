class Solution {
   public:
    int subsetXORSum(vector<int>& nums) {
        return backtrack(nums, 0, 0);
    }

   private:
    int backtrack(vector<int>& nums, int index, int currentXor) {
        // We have formed one complete subset
        if (index == nums.size()) {
            return currentXor;
        }

        // Choice 1: include nums[index]
        int include = backtrack(nums, index + 1, currentXor ^ nums[index]);

        // Choice 2: skip nums[index]
        int skip = backtrack(nums, index + 1, currentXor);

        return include + skip;
    }
};