class Solution {
   public:
    int mySqrt(int x) {
        for (int i = 1; i <= x; i++) {
            int y = i * i;
            if (y == x) {
                return i;
            } else if (y > x) {
                return i - 1;
            } else {
                continue;
            }
        }
    }
};