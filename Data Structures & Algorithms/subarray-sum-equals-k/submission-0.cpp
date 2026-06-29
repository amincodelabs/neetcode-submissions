class Solution {
   public:
    int subarraySum(vector<int>& nums, int k) {
        int result = 0;
        int n = nums.size();
        unordered_map<int, int> counts;
        counts[0] = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (counts.find(sum - k) != counts.end()) {
                result += counts[sum - k];
            }
            counts[sum]++;
        }

        return result;
    }
};