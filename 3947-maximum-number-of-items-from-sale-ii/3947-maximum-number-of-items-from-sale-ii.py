
class Solution:
    def maximumSaleItems(self, items: list[list[int]], budget: int) -> int:
        n = len(items)

        # Count factors
        cnt = [0] * (n + 1)
        min_price = float('inf')

        for f, p in items:
            cnt[f] += 1
            min_price = min(min_price, p)

        # Calculate free-item opportunities
        gain = [0] * (n + 1)

        for i in range(1, n + 1):
            for j in range(i, n + 1, i):
                gain[i] += cnt[j]

            # Exclude only the current item itself
            gain[i] -= 1

        # Sort by price
        items.sort(key=lambda x: x[1])

        ans = 0
        remaining = budget

        # Buy items that provide an additional free item
        for f, p in items:
            if p >= 2 * min_price:
                break

            take = min(gain[f], remaining // p)

            ans += 2 * take
            remaining -= take * p

        # Spend remaining budget on cheapest items
        ans += remaining // min_price

        return ans
