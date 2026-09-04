class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {

            int prefMax = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                prefMax = Math.max(prefMax, nums[j]);
            }
            
            int suffMin = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                suffMin = Math.min(suffMin, nums[j]);
            }
            
            if (prefMax - suffMin <= k) {
                return i;
            }
        }
        
        return -1;    
    }
}