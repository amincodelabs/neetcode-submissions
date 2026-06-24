class Solution {
   public:
    bool isHappy(int n) {
        unordered_set<int> seen;

        while (n != 1) {
            if (seen.find(n) != seen.end()) {
                return false;
            }
            seen.insert(n);
            n = getNext(n);
        }

        return true;
    }

   private:
    int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;    // take last digit
            sum += digit * digit;  // add square
            n /= 10;               // remove last digit
        }

        return sum;
    }
};
