package diagonalTraverse;

//TC O(m * n) where m is the row and n is the columns
// SC O(1) if we don't count the output array size

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int M  = mat.length;
        int N = mat[0].length;
        int SIZE = M * N;

        int row = 0, col = 0;

        int[] res = new int[SIZE];
        int resIndex = 0;

        for (int i=0; i<SIZE; i++){
            res[resIndex++] = mat[row][col];

            // update row col
            if ( (row + col) % 2 == 0){     //up
                if (col == N - 1) row++;
                else if (row == 0) col++;
                else {
                    row--;
                    col++;
                }

            } else {   // down
                if (row == M - 1) col++;
                else if (col == 0) row++;
                else {
                    row++;
                    col--;
                }
            }

        }
        return res;

    }
}
