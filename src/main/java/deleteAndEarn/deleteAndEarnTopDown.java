package deleteAndEarn;

import java.util.HashMap;
import java.util.Map;

// where n is the length of nums, k is the maximum element in nums
// TC (n+k) because we populate gains then call function k times
// SC (n+k) because k each for gains,  n for memo, k for recursion

public class deleteAndEarnTopDown {
  
  Map<Integer, Integer> gains;
  Map<Integer, Integer> memo;
  
    public int deleteAndEarn(int[] nums) {
    gains = new HashMap<>();  // SC O(n)
    memo = new HashMap<>(); // SC O(k)
    
    int maxInNums = 0;
    
    for (int i: nums){
      gains.put(i, gains.getOrDefault(i,0) + i); // TC O(n)
      maxInNums = Math.max(maxInNums,i);
    }
    
    return maxPoints(maxInNums); // TC O(k), each call is O(1) thanks to memoization, SC O(k)
    
  }
  
  
  private int maxPoints(int i){
    
    if (i == 0) return 0;
    if (i == 1) return gains.getOrDefault(1,0);
    if (memo.containsKey(i)) return memo.get(i);
    
    int maxPoints = Math.max(maxPoints(i-1), maxPoints(i-2) + gains.getOrDefault(i,0));
    memo.put(i, maxPoints);
    return maxPoints;
  }
}
