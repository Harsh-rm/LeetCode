class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
#         nums = nums.sort()
#         temp = int(len(nums))
#         print(temp)
        
        return sorted(nums)[-k]
#         temp = nums[0]
# #         for j in range(1 , k):
# #             for i in range(1, len(nums)):
# #                 if nums[i] > temp: temp = nums[i]
            
# #             nums.remove(temp)
            
#         return max(nums)