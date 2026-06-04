class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int result = nums[0];

        for(int i = 0; i < nums.size(); i++) {
            int current = nums[i];
            result = max(result, current);
            for(int j = i + 1; j < nums.size(); j++) {
                current *= nums[j];
                result = max(result, current);
            }
        }

        return result;
    }
};
