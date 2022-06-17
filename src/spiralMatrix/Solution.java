package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // TC O(m*n) where m is the row, and n is the columns of matrix
    // SC O(1) if we don't include the result array

    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;

        List<Integer> res = new ArrayList();

        while (res.size() < row * col) {

            for (int i = left; i <= right; i++) {
                if (top <= bottom) res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                if (left <= right) res.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left; i--) {
                if (top <= bottom) res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                if (left <= right) res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }

}
