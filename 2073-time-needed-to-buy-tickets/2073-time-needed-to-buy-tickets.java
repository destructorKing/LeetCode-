class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) 
    {
        int time = 0;
        int n = tickets.length;

        for(int i = 0; i < n; i++)
            time += Math.min(tickets[i],tickets[k]-(i>k?1:0));

        return time;   
    }
}