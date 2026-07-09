class Solution {
   public:
    bool isValid(string s) {
        stack<char> records;

        for (char c : s) {
            if (c == '{' || c == '(' || c == '[') {
                records.push(c);
            } else {
                if (!records.empty()) {
                    char top = records.top();
                    records.pop();
                    if (c == '}' && top != '{' || c == ')' && top != '(' ||
                        c == ']' && top != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return records.empty();
    }
};