package mergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;

// TC O(nlogn) where n is the length of intervals
// SC O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> result = new LinkedList<>();
        for (int i=0; i<intervals.length; i++){
            if (result.isEmpty() || result.getLast()[1] < intervals[i][0]){ // no overlap
                result.add(intervals[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1],intervals[i][1]);
            }
        }
        int len = result.size();
        return result.toArray(new int[len][]);
    }
}
