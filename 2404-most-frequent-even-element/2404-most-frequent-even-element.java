class Solution {
    public int mostFrequentEven(int[] nums) {
        
        int freq[] = new int[100001];

        for(int num : nums)
        {
            if(num % 2 == 0)
                freq[num]++;
        }

        int ans = -1;
        int maxFreq = 0;

        for(int i = 0; i < freq.length; i += 2)
        {
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                ans = i;
            }
        }
        return ans;
    }
}