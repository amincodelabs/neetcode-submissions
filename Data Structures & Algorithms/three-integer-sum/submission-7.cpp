class Solution {
   public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        int target = 0;
        vector<vector<int>> result;

        // Sort the array so we can use the two-pointer technique.
        sort(nums.begin(), nums.end());

        for (int i = 0; i < n; i++) {
            // Since the array is sorted, if nums[i] is positive,
            // all numbers after it are also positive, so sum cannot be 0.
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for i to avoid duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Find two numbers after i that together with nums[i] make 0.
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Sum is too large, so move right pointer left
                // to try a smaller number.
                if (sum > target) {
                    right--;
                }

                // Sum is too small, so move left pointer right
                // to try a larger number.
                else if (sum < target) {
                    left++;
                }

                // Found a valid triplet.
                else {
                    result.push_back({nums[i], nums[left], nums[right]});

                    // Move both pointers to look for the next possible triplet.
                    left++;
                    right--;

                    // Skip duplicate left values to avoid duplicate triplets.
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
};