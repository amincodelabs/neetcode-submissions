class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        answer = {}

        for s in strs:
            count = [0] * 26

            for ch in s:
                count[ord(ch) - ord('a')] += 1

            key_parts = []
            for i in range(26):
                key_parts.append('#')
                key_parts.append(str(count[i]))
            key = ''.join(key_parts)

            if key not in answer:
                answer[key] = []
            answer[key].append(s)

        return list(answer.values())