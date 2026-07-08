class Solution {
   public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());
        int result = 0;
        int left = 0;
        int right = people.size() - 1;

        while (left <= right) {
            int remain = limit - people[right--];
            result++;
            if (left <= right && remain >= people[left]) {
                left++;
            }
        }
        return result;
    }
};