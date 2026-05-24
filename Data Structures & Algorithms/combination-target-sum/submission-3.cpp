class Solution {
public:
    vector<vector<int>> result;

    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<int> combination;
        backtrack(nums, target, combination, 0);
        return result;
    }

    void backtrack(vector<int>& nums, int target, vector<int>& combination, int index) {
        // We found a valid combination
        if (target == 0) {
            result.push_back(combination);
            return;
        }

        // Stop if target becomes negative or we've checked all numbers
        if (target < 0 || index >= nums.size()) {
            return;
        }

        // ---------------------------------------------------
        // Choice 1: include nums[index]
        // Since numbers can be reused unlimited times,
        // we stay at the same index after taking it.
        // ---------------------------------------------------
        combination.push_back(nums[index]);
        backtrack(nums, target - nums[index], combination, index);

        // Undo the choice (backtrack)
        combination.pop_back();

        // ---------------------------------------------------
        // Choice 2: skip nums[index] and move to the next number
        // ---------------------------------------------------
        backtrack(nums, target, combination, index + 1);
    }
};