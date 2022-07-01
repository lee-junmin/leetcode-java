package findMinInSortedArray;
// T O(n) S O(1)

  class Solution {
    public int findMin(int[] nums) {
      int res = nums[0];
      int left = 0;
      int right = nums.length - 1;
    
      // take care of edge cases
      if (nums.length == 1) return nums[0];
      if (nums.length == 2) return Math.min(nums[0], nums[1]);
    
    
      while ( left <= right){
        if (nums[left] < nums[right]){
          res = Math.min(res, nums[left]);
          break;
        }
      
        int mid = left + (right - left) / 2;
      
        res = Math.min(res, nums[mid]);
      
      
        if (nums[left] <= nums[mid]){
          left =  mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return res;
    }

  
  
  }
