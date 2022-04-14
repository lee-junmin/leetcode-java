package maxSubarray;

/*
INTRO
  There are a number of ways to do this.
  1. the brute force approach which would be O(n^3) or O(n^2) depending on how you would sum
  2. the divide and conquer approach which would be O(nlogn)
  In this solution we will do Kadane's algorithm approach whis is O(n)
  
  IDEA
  We will slide through the list and sum the elements up
  when sum of the elements so far is lower than 0
  we will ditch it and start summing up again from the current point
  this is possible because a sub array with a sum of a negative number won't contribute to building a max subarray
  out of all the sums we've done the largest will be the max subarray
  
  STEPS
  1. declare variables for the max so far and current max with lowest possible numbers
  2. scan through the list
  3. if current_max is lower than 0 assign the current number to current max
  4. otherwise add it up to the current max
  5. at the end of the loop update max_so_far if current_max is higher
  6. return max_so_far
  
  REVIEW
  time complexity O(n)
  */
 


class Solution {
  public int maxSubArray(int[] nums) {
    
    // -2  1  -3  4  -1  2  1  -5  4
    
    //  (maxSoFar)
    // max so far : leave the current max value
    
    // decisions (maxCurr)
    // 1) extend to new element
    // 2) start with the new element
    
    int maxSoFar = -(int)Math.pow(10,4);
    int maxCurr= -(int)Math.pow(10,4);
    
    for (int i=0; i<nums.length; i++){
      
      maxCurr  = Math.max(maxCurr + nums[i], nums[i]);
      maxSoFar = Math.max(maxCurr,maxSoFar);
    }
    
    return maxSoFar;
    
    
    
    
  }
}
