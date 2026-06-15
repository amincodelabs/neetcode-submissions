// Binary Search on the answer.
// Time: O(n * log m), where n = piles.length() and m = max(piles)
// Space: O(1)
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        // Maximum possible eating speed.
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;

        // Stores the best valid speed found so far.
        int k = maxPile;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Calculate hours needed if eating at speed = mid.
            long long totalHours = 0;
            for (int pile : piles) {
                // ceil(pile / mid)
                totalHours += (1LL * pile + mid - 1) / mid;
            }

            if (totalHours <= h) {
                // mid works, try to find a smaller valid speed.
                k = mid;
                right = mid - 1;
            } else {
                // mid is too slow, increase the speed.
                left = mid + 1;
            }
        }

        return k;
    }
};