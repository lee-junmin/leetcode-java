package searchA2DMatrix;

// TC O(log m + log n)
// SC O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int low = 0;
        int high = ROWS - 1;
        int targetRow = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (target > matrix[mid][COLS - 1]){
                low = mid + 1;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                targetRow = mid;
                break;
            }
        }

        if (low > high) return false;

        int left = 0;
        int right = COLS - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target > matrix[targetRow][mid]){
                left = mid + 1;
            } else if (target < matrix[targetRow][mid]){
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;


    }
}