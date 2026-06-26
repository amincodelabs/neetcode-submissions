class Solution {
   public:
    vector<string> stringMatching(vector<string>& words) {
        vector<string> result;

        for (auto& w1 : words) {
            for (auto& w2 : words) {
                if (w1 == w2) {
                    continue;
                }
                if (isSubstring(w1, w2)) {
                    result.push_back(w1);
                    break;
                }
            }
        }

        return result;
    }

   private:
    bool isSubstring(string small, string big) {
        if (small.size() > big.size()) {
            return false;
        }

        for (int i = 0; i <= big.size() - small.size(); i++) {
            int j = 0;

            while (j < small.size() && big[i + j] == small[j]) {
                j++;
            }

            if (j == small.size()) {
                return true;
            }
        }

        return false;
    }
};