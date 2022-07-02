package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // TC O(m*n) where m is the row, and n is the columns of matrix
    // SC O(1) if we don't include the result array

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0, bottom = matrix.length;
        int left = 0, right  = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        while (top < bottom && left < right){

            for(int i=left; i<right; i++){
                res.add(matrix[top][i]);
            }
            if (++top == bottom) break;

            for (int i=top; i<bottom; i++){
                res.add(matrix[i][right-1]);
            }
            if (left == --right) break;

            for (int i=right - 1;  i>= left; i--){
                res.add(matrix[bottom-1][i]);
            }
            if (top == --bottom) break;

            for (int i=bottom - 1; i>=top; i-- ){
                res.add(matrix[i][left]);
            }
            if (++left == right) break;
        }

        return  res;

    }

}
