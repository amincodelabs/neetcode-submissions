class Solution:
    def maxArea(self, heights: List[int]) -> int:
        result = 0
        left, right = 0, len(heights) - 1

        while left < right:
            area = min(heights[left], heights[right]) * (right - left)
            result = max(result, area)
            if heights[left] > heights[right]:
                right -= 1
            else:
                left += 1

        return result