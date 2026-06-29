class Solution {
   public:
    vector<int> majorityElement(vector<int>& nums) {
        unordered_map<int, int> count;
        for (int num : nums) {
            count[num]++;
        }

        vector<int> result;
        int k = nums.size() / 3;
        for (auto& [num, cnt] : count) {
            if (cnt > k) {
                result.push_back(num);
            }
        }

        return result;
    }
};