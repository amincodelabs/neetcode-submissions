class Solution {
public:
    vector<vector<int>> result;

    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        dfs(0, {}, 0, nums, target);
        return result;
    }

    void dfs(int index, vector<int> combination, int total, vector<int>& nums, int target) {
        if(total == target) {
            result.push_back(combination);
            return;
        }

        for(int j = index; j < nums.size(); j++) {
            if(total + nums[j] > target) {
                return;
            }
            combination.push_back(nums[j]);
            dfs(j, combination, total + nums[j], nums, target);
            combination.pop_back();
        }
    }

};
