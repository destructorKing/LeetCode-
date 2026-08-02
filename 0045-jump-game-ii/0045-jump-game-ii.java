class Solution {
    public int jump(int[] nums) 
    {
        int max_reach = 0;
        int current = 0;
        int jumps = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            max_reach = Math.max(max_reach,nums[i]+i);

            if(i==current)
            {
                jumps++;
                current = max_reach;
            }
        }

        return jumps;   
    }
}