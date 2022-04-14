package twoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    
    // 2,7,11,15  (9)
    
    // === seen map ===
    // [7] --> 0
    
    for (int i=0; i<nums.length; i++){
      if (seen.containsKey(nums[i])){
        return new int[]{seen.get(nums[i]), i};
      }
      int pair = target-nums[i];
      seen.put(pair,i);
    }
    return null;
  }
}