class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()

        for index, num in enumerate(nums):
            if num > 0 :
                continue
            if index > 0 and num == nums[index - 1]:
                continue
            
            left, right = index + 1, len(nums) - 1
            while left < right:
                threeSum = num + nums[left] + nums[right]
                if threeSum > 0:
                    right -= 1
                elif threeSum < 0:
                    left += 1
                else:
                    result.append([num, nums[left], nums[right]])
                    left += 1
                    while nums[left] == nums[left - 1] and left < right:
                        left += 1
        return result


        