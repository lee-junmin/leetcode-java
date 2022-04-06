
/*

SUMMARY
two pointers at start and end. array is sorted, so if sum is larger shift right pointer, smaller shift left pointer

IDEA
we will use the fact that the input array is sorted
we put a pointer at each beginning and end
if the sum is smaller than the target, we shift the left because it needs to get larger
if the sum is larger we shift the right

 */
package TwoSumII;

public class TwoSumII {
  
  public static int[] twoSum(int[] numbers, int target){
    // set left and right pointer
    int l = 0;
    int r = numbers.length-1;
    
    while (numbers[l] + numbers[r] != target) {
      if (numbers[l] + numbers[r] > target) {
        r--;
      } else if (numbers[l] + numbers[r] < target) {
        l++;
      }
    }
    
    return new int[]{l+1,r+1};
    
    
  }
  public static void main (String[] args){
    int[] input = {1,3,4,5,7,10,11};
    System.out.println(twoSum(input,9)[0]);
    System.out.println(twoSum(input,9)[1]);
  }
}
