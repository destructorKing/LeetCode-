class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[101];

        for (int[] log : logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

        int population = 0;
        int maxPopulation = 0;
        int result = 1950;

        for (int i = 0; i < 101; i++) {
            population += diff[i];

            if (population > maxPopulation) {
                maxPopulation = population;
                result = 1950 + i;
            }
        }

        return result;
    }
}