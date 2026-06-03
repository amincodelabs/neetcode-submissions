// Bitwise Exclusive OR
// Time: O(n), Space: O(1)
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int result = 0;
        for(int i = 0; i <= nums.size(); i++) {
            result = result ^ i;
        }
        for(int num : nums) {
            result = result ^ num;
        }
        return result;
    }
};