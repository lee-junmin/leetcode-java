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

  
}
