class Solution {
   public:
    int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long long y = (long long) mid * mid;
            if (y > x) {
                right = mid - 1;
            } else if (y < x) {
                left = mid + 1;
                result = mid;
            } else {
                return mid;
            }
        }

        return result;
    }
};