// Dynamic Programming - Top-Down
// Time: O(n), Space: O(n)
class Solution {
public:
    vector<int> cache;

    int climbStairs(int n) {
        cache.resize(n, -1);
        return dfs(0, n);
    }

    int dfs(int i, int n) {
        if(i == n) return 1;
        if(i > n) return 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = dfs(i + 1, n) + dfs(i + 2, n);
    }
};
/*
Stack Visualization
n = 5

dfs(0) → calls dfs(1)
  dfs(1) → calls dfs(2)
    dfs(2) → calls dfs(3)
      dfs(3) → calls dfs(4)
        dfs(4) → calls dfs(5)
          dfs(5) → base case, returns 1 (stored in memo[5])
        back to dfs(4): now tries dfs(6) → returns 0, returns 1 to dfs(3)
      back to dfs(3): tries dfs(5) → memo says 1, returns 2 to dfs(2)
    back to dfs(2): tries dfs(4) → memo says 1, returns 3 to dfs(1)
  back to dfs(1): tries dfs(3) → memo says 2, returns 5 to dfs(0)
back to dfs(0): tries dfs(2) → memo says 3, returns 8

*/