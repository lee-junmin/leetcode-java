package pascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// TC O(n^2) where  n is numRows
// SC O(1) if we don't  count the output

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>(Arrays.asList(1)));
        for (int  i=1; i<numRows; i++){
            List<Integer> currList = new ArrayList<>();
            List<Integer> prevList = res.get(i-1);
            currList.add(1);
            for (int j=0; j<prevList.size() - 1; j++){
                currList.add(prevList.get(j) + prevList.get(j+1));
            }
            currList.add(1);
            res.add(currList);
        }

        return res;
    }
}
