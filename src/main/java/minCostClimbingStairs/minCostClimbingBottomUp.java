package minCostClimbingStairs;

public class minCostClimbingBottomUp {
  public int minCostClimbingStairs(int[] cost) {
    int downOne = 0;  // cost of "arriving" at 0 or 1 is free
    int downTwo = 0;  // because we pay when we leave the steps
    
    for(int i=2; i<cost.length + 1; i++){ // length + 1 because I need to arrive at one step beyond the last step
      int originalDownOne = downOne;
      // cost[i-1] and cost[i-2] are the prices I pay when I "leave" the steps
      downOne = Math.min(downOne + cost[i-1], downTwo + cost[i-2]);
      downTwo = originalDownOne;
    }
    return downOne;
  }
}
