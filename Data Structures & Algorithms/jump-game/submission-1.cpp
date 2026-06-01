// Greedy
// Time: O(n), Space: O(1)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int goal = nums.size() - 1;

        for(int i = nums.size() - 2; i >= 0; i--) {
            int jump = nums[i];
            if(i + jump >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
};
