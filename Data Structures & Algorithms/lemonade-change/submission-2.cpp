class Solution {
   public:
    bool lemonadeChange(vector<int>& bills) {
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fives++;
                    break;

                case 10:
                    tens++;

                    // Give back $5 change
                    if (fives > 0) {
                        fives--;
                    } else {
                        return false;
                    }
                    break;

                case 20:
                    // Prefer giving one $10 and one $5
                    if (fives > 0 && tens > 0) {
                        fives--;
                        tens--;
                    } else if (fives >= 3) {
                        fives -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
};