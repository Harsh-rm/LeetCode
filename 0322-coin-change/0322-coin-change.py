class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or amount == 0:
            return 0

        memo = {}

        def helper(amount: int, index: int) -> int:
            if amount == 0:
                return 0
            
            if amount < 0 or index == len(coins):
                return float('inf')

            if (amount, index) in memo:
                return memo[(amount, index)]

            case0 = helper(amount, index + 1) 

            case1 = helper(amount - coins[index], index)
            if case1 != float('inf'):
                case1 += 1

            memo[(amount, index)] = min(case0, case1)

            return memo[(amount, index)]

        result = helper(amount, 0)

        return -1 if result == float('inf') else result


            