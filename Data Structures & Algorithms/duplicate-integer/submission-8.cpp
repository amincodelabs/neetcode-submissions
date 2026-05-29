class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_map<int, int> map;
        for(int i = 0; i < nums.size(); i++) {
            map[nums[i]]++; 
        }
        for(auto &[n, c] : map) {
            if(c > 1) {
                return true;
            }
        }

        return false;
    }
};