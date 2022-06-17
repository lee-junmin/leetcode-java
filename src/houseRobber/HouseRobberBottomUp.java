package houseRobber;

public class HouseRobberBottomUp {
  // TC O(n) SC O(n)
  public int rob(int[] nums) {
    int len = nums.length;
    if (len == 1) return nums[0];
    
    int[] memo = new int[nums.length];
    
    memo[0] = nums[0];
    memo[1] = Math.max(nums[0], nums[1]);
    
    for(int i=2; i<len; i++){
      memo[i] = Math.max(memo[i-1], memo[i-2] + nums[i]);
    }
    return memo[len - 1];
  }
  // TC O(n) SC O(1)
  public int rob_spaceOpt(int[] nums) {
    
    int len = nums.length;
    if (len == 1) return nums[0];
    int before = 0;
    int current = 0;
  
    for (int num : nums) {
      int temp = before;
      before = current;
      current = Math.max(current, temp + num);
    
    }
    return current;
  }
}
