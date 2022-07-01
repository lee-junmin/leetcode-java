package minCostClimbingStairs;

import java.util.HashMap;
import java.util.Map;

// where n is the length of the cost array
// TC O(n) because we call the gen function for each element.
// the gen function is O(1) because we use memoization
// SC O(n) because of the map

public class minCostClimbingTopDown {
  Map<Integer, Integer> memo;
  int[] cost;
  
  public int minCostClimbingStairs(int[] cost) {
    
    memo = new HashMap<>();
    this.cost = cost;
    
    return gen(cost.length);
  }
  
  // state variable is the current index I'm at
  // return value is the cost to get to the state i
  
  private int gen(int i){
    if (i == 0 || i == 1) return 0;
    if (memo.containsKey(i)) return memo.get(i);
    
    int downOne = gen(i-1) + cost[i-1];
    int downTwo = gen(i-2) + cost[i-2];
    int result = Math.min(downOne, downTwo);
    memo.put(i,result);
    
    return result;
    
  }
}
