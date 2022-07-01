package dailyTemperatures;
// TC O(n) where n is the length of the input array
// the total number of loops of the while loop doesn't exceed n because we are jumping
// and that prevents us from visiting an index twice
// SC O(1) if we don't count the output array (result)


class SolutionArray {
    public int[] dailyTemperatures(int[] temperatures) {

        int LENGTH = temperatures.length;
        int maxSoFar = Integer.MIN_VALUE;
        int[] result = new int[LENGTH];

        for (int i=LENGTH-1; i>=0; i--){
            int todayTemp = temperatures[i];

            // leave as 0 if there are no warmer days
            if (maxSoFar <= todayTemp){
                maxSoFar = todayTemp;
                continue;
            }
            int waitDays = 1;
            while (temperatures[i + waitDays] <= todayTemp){
                waitDays += result[i + waitDays];
            }
            result[i] = waitDays;
        }
        return result;
    }
}