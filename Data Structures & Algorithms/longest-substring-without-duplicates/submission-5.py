# Brute Force
# O(n * m), O(m)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        result = 0
        for i in range(n):
            charSet = set()
            for j in range(i, n):
                if s[j] in charSet:
                    break
                charSet.add(s[j])
            result = max(result, len(charSet))
        return result
