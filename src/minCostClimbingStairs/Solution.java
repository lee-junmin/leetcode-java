package minCostClimbingStairs;

public class Solution {
  public int minCostClimbingStairs(int[] cost) {
    
    //  input           10   15   20
    
    //  min till end              20
    //  min till end         15   20 --> init
    //  min till end    25   15   20
    
    //                  25   15  --> return the small of these two
    
    int len = cost.length;
    int oneJump = cost[len-2];
    int twoJump = cost[len-1];
    
    
    for (int i = len-3; i >=0; i-- ){
      int oldTwoJump = twoJump;
      twoJump = oneJump;
      oneJump = cost[i] + Math.min(oneJump, oldTwoJump);
    }
    
    return Math.min(oneJump,twoJump);
    
    
    
    
    
    
  }
  
  //recursive answer
  // (0) 10 15 | 20 (0)
  // think that there is a 0 value at the beginning and end
  // cost will be more than 2 elements
  public int minCostClimbingStairs_r(int[] cost) {
    return minCost(cost,cost.length);
    
  }
  
  private int minCost(int[] cost, int curr){
    if (curr == -1){
      return 0;
    }
    
    if (curr == 0) {
      return cost[0];
    }
    if (curr == 1){
      return cost[1];
    }
    
    int currValue = 0;
    
    
    if (curr != cost.length) {
      currValue = cost[curr];
    }
    
    int r1 = currValue + minCost(cost,curr-1);
    int r2 = currValue + minCost(cost,curr-2);
    
    return Math.min(r1,r2);
    
    
  }

  
}
