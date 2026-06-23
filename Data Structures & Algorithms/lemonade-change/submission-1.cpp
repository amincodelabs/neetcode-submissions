class Solution {
   public:
    bool lemonadeChange(vector<int>& bills) {
        for (int bill : bills) {
            int changeNeeded = bill - 5;
            if (changeNeeded > 0) {
                if (!canChange(changeNeeded)) return false;
            }
            changes[bill] = changes[bill] + 1;
            balance += 5;
        }

        return true;
    }

   private:
    unordered_map<int, int> changes;
    int balance = 0;

    bool canChange(int amount) {
        if (amount == 0) {
            return true;
        }
        if (amount >= 10 && changes[10] > 0) {
            changes[10] = changes[10] - 1;
            return canChange(amount - 10);
        } else if (amount >= 5 && changes[5] > 0) {
            changes[5] = changes[5] - 1;
            return canChange(amount - 5);
        } else {
            return false;
        }
    }
};