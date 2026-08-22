class Solution {
    public boolean checkDivisibility(int n) 
    {
        return n % (sumOfDigits(n)+ productOfDigits(n)) == 0;    
    }
    public int sumOfDigits(int n)
    {
        int sum = 0;
        while(n != 0)
        {
            sum += n%10;
            n /=10;
        }
        return sum;
    }

    public int productOfDigits(int n)
    {
        int prod = 1;
        while(n != 0)
        {
            prod *= n%10;
            n /=10;
        }
        return prod;
    }
}