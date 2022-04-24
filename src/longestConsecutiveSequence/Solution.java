package longestConsecutiveSequence;

import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> pool = new HashSet<>();
        int maxSoFar = 0;

        // create hashset out of the given array
        for (int n: nums){
            pool.add(n);
        }

        // find the starters & next
        for (int n: nums){
            if (!pool.contains(n-1)){
                // this is for starters
                int len = 1;
                while (pool.contains(n+1)){
                    len++;
                    n++;
                }
                maxSoFar = Math.max(maxSoFar,len);
            }
        }
        return maxSoFar;
    }
}
