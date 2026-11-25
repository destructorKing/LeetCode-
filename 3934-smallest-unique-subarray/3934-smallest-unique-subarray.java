
class Solution {
    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE = 911382323L;

    long[] h1, h2, p1, p2;

    boolean check(int len) {
        int n = h1.length - 1;

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {
            long x = (h1[i + len]
                    - h1[i] * p1[len] % MOD1 + MOD1) % MOD1;

            long y = (h2[i + len]
                    - h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            long key = x * MOD2 + y;

            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) return true;
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {
            long v = nums[i] + 1L;

            h1[i + 1] = (h1[i] * BASE + v) % MOD1;
            h2[i + 1] = (h2[i] * BASE + v) % MOD2;

            p1[i + 1] = p1[i] * BASE % MOD1;
            p2[i + 1] = p2[i] * BASE % MOD2;
        }

        int low = 1, high = n, ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
