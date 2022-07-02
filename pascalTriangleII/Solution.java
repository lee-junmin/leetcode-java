package pascalTriangleII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0)  return res;

        for(int level=1; level<rowIndex+1; level++){
            for(int j=level-1; j>=1; j--){
                res.set(j, res.get(j-1) + res.get(j));
            }
            res.add(1);
        }

        return res;
    }
}
