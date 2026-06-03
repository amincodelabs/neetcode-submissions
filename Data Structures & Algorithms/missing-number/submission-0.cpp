class Solution {
   public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        vector<int> array(n + 1);
        for (int i = 0; i <= n; i++) {
            array[i] = i;
        }

        for (int num : nums) {
            array[num] = -1;
        }

        for (int a : array) {
            if (a != -1) {
                return a;
            }
        }

        return -1;
    }
};
