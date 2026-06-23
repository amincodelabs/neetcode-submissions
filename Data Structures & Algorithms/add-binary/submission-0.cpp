class Solution {
   public:
    string addBinary(string a, string b) {
        string result = "";
        int carry = 0;

        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());

        for (int i = 0; i < max(a.length(), b.length()); i++) {
            int digitA = i < a.length() ? a[i] - '0' : 0;
            int digitB = i < b.length() ? b[i] - '0' : 0;

            int total = digitA + digitB + carry;
            char c = (total % 2) + '0';
            result += c;
            carry = total / 2;
        }

        if (carry) {
            result += '1';
        }

        reverse(result.begin(), result.end());
        return result;
    }
};