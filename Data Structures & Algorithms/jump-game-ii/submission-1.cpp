class Solution {
   public:
    int jump(vector<int>& nums) {
        unordered_map<int, int> memo;
        return dfs(nums, 0, memo);
    }

   private:
    int dfs(vector<int>& nums, int index, unordered_map<int, int>& memo) {
        if (memo.count(index)) {
            return memo[index];
        }
        if (index == nums.size() - 1) {
            return 0;
        }
        if (nums[index] == 0) {
            return 1000000;
        }

        int result = 1000000;
        int end = min((int)nums.size(), index + nums[index] + 1);
        for (int j = index + 1; j < end; j++) {
            result = min(result, 1 + dfs(nums, j, memo));
        }
        memo[index] = result;
        return result;
    }
};
