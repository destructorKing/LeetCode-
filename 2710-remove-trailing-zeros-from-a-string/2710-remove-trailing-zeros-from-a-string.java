class Solution {
    public String removeTrailingZeros(String num) 
    {
        int left = 0;
        int right = num.length() - 1;

        while(left < right && num.charAt(right) == '0')
            right--;

        return num.substring(left,right+1);   
    }
}