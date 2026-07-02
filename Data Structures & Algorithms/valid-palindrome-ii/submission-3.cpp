#include <cctype>
#include <iostream>
#include <string>

// Brute Force - O(n^2), O(n)
class Solution {
   public:
    bool validPalindrome(string s) {
        if (checkPalindrome(s)) {
            return true;
        }

        for (size_t i = 0; i < s.length(); i++) {
            string substring;// = s.substr(0, i) + s.substr(i + 1);
            for(int j = 0; j < i; j++) {
                substring += s[j];
            }
            for(int j = i + 1; j < s.length(); j++) {
                substring += s[j];
            }

            if (checkPalindrome(substring)) {
                return true;
            }
        }

        return false;
    }

   private:
    bool checkPalindrome(string s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
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