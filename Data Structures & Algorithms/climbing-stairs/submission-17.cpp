// DP - TopDown
// Time: O(n), Space: O(n)
class Solution {
   public:
    vector<int> cache;

    int climbStairs(int n) {
        cache.resize(n, -1);
        return dfs(0, n);
    }

   private:
    int dfs(int i, int n) {
        if (i == n) {
            return 1;  // We reached end, we found a path
        }
        if (i > n) {
            return 0;  // Out of bound(staircase) and not considered as a path
        }
        if(cache[i] != -1) {
            return cache[i]; // Already solved this subproblem
        }

        cache[i] = dfs(i + 1, n) + dfs(i + 2, n);
        return cache[i];
    }
};
