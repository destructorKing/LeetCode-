class Solution {
    public int sumOfUnique(int[] nums) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int sum = 0;
        for(int n : map.keySet())
        {
            if(map.get(n) == 1)
                sum += n;
        }

        return sum;    
    }
}