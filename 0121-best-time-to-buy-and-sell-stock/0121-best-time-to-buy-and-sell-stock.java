class Solution {
    public int maxProfit(int[] prices) 
    {
        int min = prices[0];
        int maxProfit= 0;

        for(int price: prices)
        {
            if(price<min)
                min=price;
            maxProfit= Math.max(maxProfit,price-min);
        }
        return maxProfit;
    }
}