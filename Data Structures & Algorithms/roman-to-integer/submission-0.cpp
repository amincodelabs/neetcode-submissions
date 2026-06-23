class Solution {
   public:
    int romanToInt(string s) {
        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int x = roman[s[i]];
            int y = roman[s[i + 1]];
            if(x < y) {
                result -= x;
            } else {
                result += x;
            }
        }

        result += roman[s[s.length() - 1]];
        return result;
    }

   private:
    map<char, int> roman = {{'I', 1},   {'V', 5},   {'X', 10},  {'L', 50},
                            {'C', 100}, {'D', 500}, {'M', 1000}};
};