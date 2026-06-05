class Solution {
   public:
    unordered_map<int, int> cache;

    int rob(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        vector<int> left(nums.begin(), nums.end() - 1);
        vector<int> right(nums.begin() + 1, nums.end());

        cache.clear();
        int res1 = dfs(left, 0);
        cache.clear();
        int res2 = dfs(right, 0);

        return max(res1, res2);
    }

   private:
    int dfs(vector<int>& nums, int i) {
        if (i >= nums.size()) {
            return 0;
        }
        if (cache.count(i)) {
            return cache[i];
        }
        cache[i] = max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
        return cache[i];
    }
};
