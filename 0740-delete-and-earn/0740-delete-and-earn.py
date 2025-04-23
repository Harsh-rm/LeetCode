class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        maxValue = 0

        for i in range(len(nums)):
            maxValue = max(maxValue, nums[i])

        dp = [0] * (maxValue + 1)

        for i in range(len(nums)):
            dp[nums[i]] += nums[i]

        print(dp)

        skip = 0
        take = dp[0]
        for i in range(1, maxValue + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)