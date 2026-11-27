class Solution:
    def successfulPairs(self, spells: list[int], potions: list[int], success: int) -> list[int]:

        potions.sort()
        n = len(potions)
        ans = []

        for spell in spells:
            left, right = 0, n

            while left < right:
                mid = left + (right - left) // 2

                if spell * potions[mid] >= success:
                    right = mid
                else:
                    left = mid + 1

            ans.append(n - left)

        return ans
        