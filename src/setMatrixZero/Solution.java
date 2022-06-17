package setMatrixZero;

// TC O(M*N) where mxn is the dimension of matrix
// SC O(1)

class Solution {


        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean firstRow = false;

            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++){
                    if (matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        if (i == 0) {
                            firstRow = true;
                        } else {
                            matrix[i][0] = 0;
                        }

                    }
                }
            }

            for (int col=1; col<n; col++) {
                if (matrix[0][col] == 0){
                    for (int row=0; row<m; row++){
                        matrix[row][col] = 0;
                    }
                }
            }

            for (int row=1; row<m; row++){
                if (matrix[row][0] == 0){
                    for (int col=0; col<n; col++){
                        matrix[row][col] = 0;
                    }
                }


            }



            if (matrix[0][0] == 0){
                for (int row=0; row<m; row++){
                    matrix[row][0] = 0;
                }
            }

            if (firstRow){
                for (int col=0; col<n; col++){
                    matrix[0][col] = 0;
                }
            }

        }



//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        List<int[]> targets = new ArrayList<>();
//
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n; j++){
//                if (matrix[i][j] == 0) targets.add(new int[]{i,j});
//            }
//        }
//
//        for (int[] target: targets){
//            for (int i=0; i<n; i++){
//                matrix[target[0]][i] = 0;
//            }
//            for (int i=0; i<m; i++){ // for each element in col
//                matrix[i][target[1]] = 0;
//            }
//        }
//    }

}
