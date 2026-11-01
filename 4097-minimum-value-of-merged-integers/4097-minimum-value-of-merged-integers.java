class Solution {
    public int minMergedInteger(int[] nums) {
        long min = Long.MAX_VALUE;

        for (int i = 0; i < nums.length; i += 2) {
            String merged = "" + nums[i] + nums[i + 1];

            long value = Long.parseLong(merged);

            min = Math.min(min, value);
        }

        return (int)min;
    }
}