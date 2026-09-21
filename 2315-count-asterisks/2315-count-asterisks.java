class Solution {
    public int countAsterisks(String s) 
    {
        boolean insideBar = false;
        int count = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == '|')
                insideBar = !insideBar;
            else if(ch == '*' && !insideBar)
                count++;
        }
        return count;   
    }
}