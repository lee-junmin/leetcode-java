package houseRobber;

import java.util.HashMap;
import java.util.Map;
// where n is the size of nums
// TC O(n) recurse
// SC O(n) memo hashmap
public class HouseRobberTopDown {
  private Map<Integer, Integer> memo;
  private int[] nums;
  
  public int rob(int[] nums) {
    this.nums = nums;
    memo = new HashMap<>();
    return gen(nums.length - 1);
  }
  // 1) state variable i is the index I am at
  // 2) gen function takes i and outputs answer
  private int gen(int i){
    // 5) base case
    if (i == 0) return nums[0];
    if (i == 1) return Math.max(nums[0], nums[1]);
    if(memo.containsKey(i)) return memo.get(i);
    
    // 4) recurrence relation
    int result = Math.max(gen(i-1), gen(i-2) + nums[i]);
    // 3) store result
    if (!memo.containsKey(i)) memo.put(i,result);
    return result;
  }
  
}
