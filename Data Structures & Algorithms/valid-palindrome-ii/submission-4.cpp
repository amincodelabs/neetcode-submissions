#include <cctype>
#include <string>
using namespace std;

// Brute Force - O(n^2), O(1)
class Solution {
   public:
    bool validPalindrome(string s) {
        if (checkPalindrome(s, -1)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (checkPalindrome(s, i)) {
                return true;
            }
        }

        return false;
    }

   private:
    bool checkPalindrome(const string& s, int skipIndex) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (left == skipIndex) {
                left++;
                continue;
            }

            if (right == skipIndex) {
                right--;
                continue;
            }

            while (left < right && !isalnum(s[left])) {
                left++;
            }

            while (left < right && !isalnum(s[right])) {
                right--;
            }

            if (tolower(s[left]) != tolower(s[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
};