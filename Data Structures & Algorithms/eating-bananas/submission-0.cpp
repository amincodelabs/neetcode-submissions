class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {

        // Determin max pile
        int maxPile = 0;
        for(int pile : piles) {
            maxPile = max(maxPile, pile);
        }

        for(int k = 1; k <= maxPile; k++) {
            int totalHour = 0;
            for(int pile : piles) {
                totalHour += (pile + k - 1) / k;
                if(totalHour > h) {
                    break;
                }
            }
            if(totalHour <= h) {
                return k;
            }
        }

        return -1;
    }
};
