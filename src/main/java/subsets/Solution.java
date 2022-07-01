package subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    
    List<List<Integer>> res = new ArrayList();
    List<Integer> subset = new ArrayList();
    
    generateSubsets(0, nums, subset, res);
    
    return res;
  }
  
  
  private void generateSubsets (int currIndex, int[] nums, List<Integer> subset, List<List<Integer>> res) {
    
    if (currIndex >= nums.length){
      res.add(new ArrayList<>(subset));
      return;
    }
    
    subset.add(nums[currIndex]);
    generateSubsets(currIndex + 1, nums, subset, res);
    
    subset.remove(subset.size() - 1);
    generateSubsets(currIndex + 1, nums, subset, res);
    
  }
}