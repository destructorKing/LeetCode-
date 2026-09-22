class Solution {
    public String digitSum(String s, int k) 
    {
        while(s.length() > k)
        {
            int n = s.length();
            StringBuilder res = new StringBuilder();

            for(int i = 0; i < n; i += k)
            {
                int sum = 0;
                for(int j = i; j < Math.min(i+k,n); j++)
                {
                    sum += s.charAt(j) - '0';
                }
                res.append(sum);
            }
            s = res.toString();
        }
        return s;    
    }
}