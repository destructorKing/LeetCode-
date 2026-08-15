class Solution {
    public int mostWordsFound(String[] sentences) 
    {
        int maxWords = 0;
        for(String sentence : sentences)
        {
            int count = 1;
            for(char ch : sentence.toCharArray())
            {
                if(ch == ' ')
                    count++;
            }
            maxWords = Math.max(maxWords,count);    
        }
        return maxWords;
    }
}
   