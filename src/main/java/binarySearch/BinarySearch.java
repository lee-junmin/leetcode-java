
/*

SUMMARY
two pointers at each end. move to mid. don't forget to skip the mid index for the next loop (r = mid - 1)


MAIN IDEA

two pointers at each end and move either of them to the middle
depending on whether the mid value is larger or smaller than the target

don't forget to skip the mid index for the next loop (example. r = mid -1)

 */

package binarySearch;

// 0 1 2 3 4 5 6 7 8

public class BinarySearch {
  public static int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length -1;
    
    while (l < r){
      int mid = (r - l) / 2 + l;
      if (nums[mid] > target){
        r = mid - 1;
      } else if (nums[mid] < target){
        l = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] input = {-1,0,3,5,9,12};
    System.out.println(BinarySearch.search(input, 9));
  }
}
