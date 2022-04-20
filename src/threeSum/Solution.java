package threeSum;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int len = nums.length;
    
    if (len < 3) return res;
    
    Arrays.sort(nums);
    int currIndex = 0;
    
    while (currIndex < len-2 && nums[currIndex] <= 0){
      int target = 0 - nums[currIndex];
      
      if (currIndex > 0 && nums[currIndex] == nums[currIndex-1]){
        currIndex++;
        continue;
      }
      
      int l = currIndex + 1;
      int r = len -1;
      
      // find two sum
      while (l < r){
        int twoSum = nums[l] + nums[r];
        if (target < twoSum) {
          r--;
        } else if (target > twoSum){
          l++;
        } else if (target == twoSum){
          // found a match, add to res
          ArrayList<Integer> match = new ArrayList<>(
            Arrays.asList(nums[currIndex], nums[l], nums[r])
          );
          if (!res.contains(match)) res.add(match);
          l++;
          r--;
        }
      }
      
      
      currIndex++;
    }
    return res;
    
  }
}
