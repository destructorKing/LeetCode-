class Solution(object):
    def climbStairs(self, n, costs):
        """
        :type n: int
        :type costs: List[int]
        :rtype: int
        """
        dp = [0] * (n + 1)

        for i in range(1, n + 1):
            dp[i] = float('inf')

            for j in range(max(0, i - 3), i):
                jump = i - j

                total = dp[j] + costs[i - 1] + jump * jump

                dp[i] = min(dp[i], total)

        return dp[n]