class Solution:
    def maximumSaleItems(self, items: List[List[int]], budget: int) -> int:
        
        n = len(items)

        gain = [1] * n
        min_price = float('inf')

        for i in range(n):
            factor = items[i][0]
            min_price = min(min_price, items[i][1])

            for j in range(n):
                if i != j and items[j][0] % factor == 0:
                    gain[i] += 1

        dp = [0] * (budget + 1)

        for i in range(n):
            price = items[i][1]

            for b in range(budget, price - 1, -1):
                dp[b] = max(
                    dp[b],
                    dp[b - price] + gain[i]
                )

       
        ans = 0

        for b in range(budget + 1):
            remaining = budget - b
            ans = max(ans, dp[b] + remaining // min_price)

        return ans