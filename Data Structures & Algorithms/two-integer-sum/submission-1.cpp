class Solution {
   public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            int compelment = target - nums[i];
            if (map.count(compelment) >= 1) {
                return { map[compelment], i };
            }
            map[nums[i]] = i;
        }

        return {};
    }
};
