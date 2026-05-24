class Solution {
   public:
    vector<vector<int>> result;

    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<int> current;
        backtrack(nums, target, current, 0);
        return result;
    }

    void backtrack(vector<int>& nums, int target, vector<int>& current, int index) {
        if(target == 0) {
            result.push_back(current);
            return;
        }
        if(target < 0 || index >= nums.size()) {
            return;
        }
        current.push_back(nums[index]);
        backtrack(nums, target - nums[index], current, index);
        current.pop_back();
        backtrack(nums, target, current, index + 1);
    }
};
