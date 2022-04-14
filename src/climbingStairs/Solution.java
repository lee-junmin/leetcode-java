package climbingStairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int climbStairs(int n) {
    if (n == 1) return 1;
    int one = 1;
    int two = 1;
    
    for (int i=1; i<n; i++){
      int originalTwo = two;
      two = one;
      one = originalTwo + one;
    }
    return one;
  }
  
  
  // DP approach 2: Topdown memoization
  
  public int climbStairs_2(int n) {
    Map<Integer,Integer> memo = new HashMap<>();
    memo.put(1,1);
    memo.put(2,2);
    return generateClimbStairs(n,memo);
  }
  
  public int generateClimbStairs(int n, Map<Integer, Integer> memo){
    if (n == 1) return 1;
    if (n == 2) return 2;
    
    if (memo.containsKey(n)) {
      return memo.get(n);
    } else {
      memo.put(n,generateClimbStairs(n-1,memo) + generateClimbStairs(n-2,memo));
      return memo.get(n);
    }
  }
  
  
}
