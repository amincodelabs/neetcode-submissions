// Brute Force
// T: O(n * m), S: O(1)
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        // Find the largest pile.
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = max(maxPile, pile);
        }

        // Try every possible eating speed.
        for (int k = 1; k <= maxPile; k++) {
            int totalHours = 0;

            for (int pile : piles) {
                // Hours needed for this pile: ceil(pile / k)
                totalHours += (pile + k - 1) / k; // Somehow rounding up. For example for 11 / 3 we want 4

                // No need to continue if we already exceeded h.
                if (totalHours > h) {
                    break;
                }
            }

            // First valid speed is the minimum answer.
            if (totalHours <= h) {
                return k;
            }
        }

        return -1; // Should never happen for valid inputs.
    }
};
