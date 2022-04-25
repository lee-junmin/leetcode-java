package searchRotatedSortedArray;

// 4 5 6 7 0 1 2 3
// l     m       h

class Solution {
    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]){
                if (target >= nums[lo] && target < nums[mid]){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            } else {
                if  (target > nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }



        return -1;
    }
}