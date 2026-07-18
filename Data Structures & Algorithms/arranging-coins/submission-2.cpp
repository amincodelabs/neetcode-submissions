class Solution {
   public:
    int arrangeCoins(int n) {
        long long left = 1, right = n, count = 0;

        while (left <= right) {
            long long mid = left + (right - left) / 2;
            long long coins = (mid * (mid + 1)) / 2;
            if (coins > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                count = max(count, mid);
            }
        }

        return count;
    }
};