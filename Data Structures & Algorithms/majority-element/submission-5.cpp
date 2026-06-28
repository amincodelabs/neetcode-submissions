class Solution {
   public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int result = 0;

        // Check every bit position of a 32-bit integer.
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            // Count how many numbers have this bit turned on.
            for (int num : nums) {
                if ((num >> bit) & 1) {
                    count++;
                }
            }  // 001 >> 001 & 001 = 001 -> true

            // If this bit appears in more than half of the numbers,
            // then this bit must belong to the majority element.
            if (count > n / 2) {
                result |= (1u << bit);
            }
        }

        return result;
    }
};