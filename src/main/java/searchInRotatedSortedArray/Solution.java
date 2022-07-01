package searchInRotatedSortedArray;
// TC O(log n) where n is the length of nums
// SC O(1)
class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]){ // first half is sorted or mid reached left pointer and the next index is right

                if (target < nums[mid] && target >= nums[left] ){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else { // second half is sorted

                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;

    }
}
