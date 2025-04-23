class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0

        memo = {}

        def helper(amount: int, index: index) -> int:
            if amount == 0:
                return 1

            if amount < 0 or index == len(coins):
                return 0

            if (amount, index) in memo:
                return memo[(amount, index)]

            case0 = helper(amount, index + 1)

            case1 = helper(amount - coins[index], index)

            memo[(amount, index)] = case0 + case1

            return memo[(amount, index)]

        return helper(amount, 0)