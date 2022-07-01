package nonOverlappingIntervals;

import java.util.Arrays;
// TC O(nlogn) where n is the length of intervals
// SC O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int limit = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            if (limit > intervals[i][0] ){ //overlap
                count++;
                limit = Math.min(limit, intervals[i][1]);
            } else {
                limit = intervals[i][1];
            }

        }
        return count;
    }
}
