class Solution {

    class MedianCost {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0;
        int rightSize = 0;

        long leftSum = 0;
        long rightSum = 0;

        void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                left.merge(val, 1, Integer::sum);
                leftSize++;
                leftSum += val;
            } else {
                right.merge(val, 1, Integer::sum);
                rightSize++;
                rightSum += val;
            }

            balance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeFrom(left, val);
                leftSize--;
                leftSum -= val;
            } else {
                removeFrom(right, val);
                rightSize--;
                rightSum -= val;
            }

            balance();
        }

        void removeFrom(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void balance() {
            // Left should contain either the same number
            // of elements as right, or one extra element.

            while (leftSize > rightSize + 1) {
                int val = left.lastKey();

                removeFrom(left, val);
                leftSize--;
                leftSum -= val;

                right.merge(val, 1, Integer::sum);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < rightSize) {
                int val = right.firstKey();

                removeFrom(right, val);
                rightSize--;
                rightSum -= val;

                left.merge(val, 1, Integer::sum);
                leftSize++;
                leftSum += val;
            }
        }

        long getCost() {
            long median = left.lastKey();

            long leftCost =
                median * leftSize - leftSum;

            long rightCost =
                rightSum - median * rightSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long INF = Long.MAX_VALUE / 4;

        // dp[i][j] = minimum cost to select
        // j non-overlapping subarrays from first i elements.

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        MedianCost mc = new MedianCost();

        for (int i = 1; i <= n; i++) {

            // Add current element to sliding window.
            mc.add(nums[i - 1]);

            // Skip current position.
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // We have a complete window of size x.
            if (i >= x) {

                long cost = mc.getCost();

                // Select this window as the j-th subarray.
                for (int j = 1; j <= k; j++) {

                    if (dp[i - x][j - 1] != INF) {

                        dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i - x][j - 1] + cost
                        );
                    }
                }

                // Remove the element leaving the window.
                mc.remove(nums[i - x]);
            }
        }

        return dp[n][k];
    }
}
