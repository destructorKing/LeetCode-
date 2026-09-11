class Solution {
    public int totalNumbers(int[] digits) 
    {
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int num = 100; num <= 999; num++) 
        {
            if (num % 2 != 0) {
                continue;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] needed = new int[10];
            needed[a]++;
            needed[b]++;
            needed[c]++;

            boolean possible = true;

            for (int d = 0; d < 10; d++) {
                if (needed[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;    
    }
}