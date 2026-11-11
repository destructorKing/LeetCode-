class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        long onlySeparate =
            (long) need1 * cost1 + (long) need2 * cost2;

        long onlyBoth =
            (long) Math.max(need1, need2) * costBoth;

        int minNeed = Math.min(need1, need2);

        long mixed =
            (long) minNeed * costBoth
            + (long) (need1 - minNeed) * cost1
            + (long) (need2 - minNeed) * cost2;

        return Math.min(onlySeparate,
               Math.min(onlyBoth, mixed));
    }
}