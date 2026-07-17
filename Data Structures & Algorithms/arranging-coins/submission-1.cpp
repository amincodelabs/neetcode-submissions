class Solution {
   public:
    int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int count = 0;
        int coins = n;
        int index = 1;
        while (coins >= index) {
            coins -= index;
            index++;
            if (coins > 0) {
                count++;
            }
        }
        return count;
    }
};