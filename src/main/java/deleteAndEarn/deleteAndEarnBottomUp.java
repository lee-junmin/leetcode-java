package deleteAndEarn;

import java.util.HashMap;
import java.util.Map;

public class deleteAndEarnBottomUp {
// where n is the length of nums and k is the maximum value in nums
  // TC O(n+k) because O(n) when we construct gains, O(k) when we iterate
  // SC O(1) because we use 2 variables (instead of an array) to store the mid results
    public int deleteAndEarn(int[] nums) {
      Map<Integer, Integer> gains = new HashMap<>();
      int maxNum = 0;
    
      for (int i: nums){
        gains.put(i, gains.getOrDefault(i,0) + i);
        maxNum = Math.max(maxNum, i);
      }
    
      // int[] memo = new int[maxNum+1];
      // memo[0] = 0;
      // memo[1] = gains.getOrDefault(1, 0);
    
      int twoDown = 0;
      int oneDown = gains.getOrDefault(1,0);
    
      for (int i=2; i<maxNum+1; i++){ // 2 3
        //memo[i] = Math.max(memo[i-1], memo[i-2] + gains.getOrDefault(i,0));
        int temp = oneDown;
        oneDown = Math.max(oneDown, twoDown + gains.getOrDefault(i,0));
        twoDown = temp;
      }
    
      return oneDown;
  }
}
