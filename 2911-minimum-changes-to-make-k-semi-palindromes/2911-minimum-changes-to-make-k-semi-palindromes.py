
class Solution:
    def minimumChanges(self, s: str, k: int) -> int:
        n = len(s)
        INF = float('inf')

        cost = [[INF] * n for _ in range(n)]

        for length in range(2, n + 1):
            for i in range(n - length + 1):

                for d in range(1, length):
                    if length % d != 0:
                        continue

                    changes = 0

                    for r in range(d):
                        left = i + r
                        right = i + length - d + r

                        while left < right:
                            if s[left] != s[right]:
                                changes += 1

                            left += d
                            right -= d

                    cost[i][i + length - 1] = min(
                        cost[i][i + length - 1],
                        changes
                    )

        dp = [[INF] * (k + 1) for _ in range(n + 1)]
        dp[0][0] = 0

        for parts in range(1, k + 1):
            for i in range(2 * parts, n + 1):
                for j in range(2 * (parts - 1), i - 1):

                    if dp[j][parts - 1] == INF:
                        continue

                    dp[i][parts] = min(
                        dp[i][parts],
                        dp[j][parts - 1] + cost[j][i - 1]
                    )

        return dp[n][k]
