class Solution {
   public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> s;

        for (int asteroid : asteroids) {
            bool destroyed = false;

            // Collision is possible only when:
            // stack top moves right and current asteroid moves left.
            while (!s.empty() && s.top() > 0 && asteroid < 0) {
                if (s.top() < -asteroid) {
                    // Stack asteroid is smaller.
                    s.pop();
                    continue;
                }

                if (s.top() == -asteroid) {
                    // Both asteroids have the same size.
                    s.pop();
                }

                // Current asteroid was destroyed either by a larger
                // asteroid or by an equal-sized asteroid.
                destroyed = true;
                break;
            }

            if (!destroyed) {
                s.push(asteroid);
            }
        }

        vector<int> result(s.size());

        for (int i = static_cast<int>(result.size()) - 1; i >= 0; i--) {
            result[i] = s.top();
            s.pop();
        }

        return result;
    }
};