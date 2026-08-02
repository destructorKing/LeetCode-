class Solution {
    public long sumAndMultiply(int n) 
    {
        if (n==0)
            return 0;

        long rev = 0;
        long x = 0 , sum = 0;

        while(n!=0)
        {
            int digit = (int)n%10;
            if(digit!=0)
                rev = rev*10 + digit;
        
            n/=10;
        }

        while(rev !=0)
        {
            int digit = (int)rev%10;
            x = x*10 + digit;
            sum += digit;
            rev/=10;
        }
        return x*sum;    
    }
}