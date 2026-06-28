class Solution {
   public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        for (auto& entry : map) {
            entry.second = {};
        }

        for (const string& str : strs) {
            int count[26] = {0};
            for (char ch : str) {
                count[ch - 'a']++;
            }

            string key = "";
            for (int c : count) {
                key.push_back('#');
                key.append(to_string(c));
            }

            map[key].push_back(str);
        }

        vector<vector<string>> result;
        for (auto& entry : map) {
            result.push_back(entry.second);
        }

        return result;
    }
};
