package insertIntervals;

import java.util.ArrayList;
import java.util.List;

// TC O(n) where n is the size of intervals
// SC O(n)

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] i: intervals){

            if (i[0] > newInterval[1]){
                res.add(newInterval);
                newInterval = i; // update newInterval so that we can keep on

            } else if (i[1] < newInterval[0]){
                res.add(i);

            }  else {
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);

    }
}
