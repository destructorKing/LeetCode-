class Solution {
    public int findNumbers(int[] nums) 
    {
        int isEven = 0; 

        for(int num : nums)
        {
            int count = 0;
            while(num != 0)
            {
                count++;
                num /= 10;
            }
            if(count % 2 == 0)
                isEven++;
        }
        return isEven;   
    }
}