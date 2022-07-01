package rotateImage;

// TC O(n) where n is the number of elements in the 2D matrix
// SC O(1) because we're doing inplace

public class Solution {

    public void rotate(int[][] matrix) {

        int len = matrix.length - 1;
        int rounds = matrix.length / 2 + matrix.length % 2;

        for(int i=0; i<rounds; i++){
            int temp = 0;
            for(int j=0; j<len-i*2; j++){
                temp = matrix[len - i - j][i]; // len = 2, i = 1, j = 0
                matrix[len - i - j][i] = matrix[len - i][len - i - j];
                matrix[len - i][len - i - j] = matrix[i + j][len - i];
                matrix[i + j][len - i] = matrix[i][i + j];
                matrix[i][i + j] = temp;
            }
        }

    }

}
