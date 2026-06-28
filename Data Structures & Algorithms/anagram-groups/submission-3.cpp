class Solution {
   public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> groups;

        for (const string& str : strs) {
            array<int, 26> count{};
            for (char ch : str) {
                count[ch - 'a']++;
            }

            string key;
            key.reserve(26 * 3);

            for (int c : count) {
                key += '#';
                key += to_string(c);
            }

            groups[key].push_back(str);
        }

        vector<vector<string>> result;
        for (auto& [key, group] : groups) {
            result.push_back(group);
        }

        return result;
    }
};
