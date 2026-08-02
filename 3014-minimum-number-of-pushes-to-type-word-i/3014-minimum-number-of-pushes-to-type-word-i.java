class Solution {
    public int minimumPushes(String word) 
    {
        int n = word.length();
        int presses = 0;

        for(int i=0; i<n; i++)
        {
            presses += (i/8)+1;
        }

        return presses;    
    }
}