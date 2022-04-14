package containsDuplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    // record see numbers
    Set<Integer> seen = new HashSet<>();
    
    for (int num: nums){
      if (seen.contains(num)) {
        return true ;
      } else {
        seen.add(num);
      }
      
    }
    
    return false;
  }
}