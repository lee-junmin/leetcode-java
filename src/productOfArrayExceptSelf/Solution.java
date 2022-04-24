package productOfArrayExceptSelf;

import java.util.Arrays;

// T O(n)   S O(1)

public class Solution {


    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1;
        int suf = 1;

        // store prefix in res
        for (int i=0; i<nums.length; i++){
            res[i] = pre;
            pre *= nums[i];
        }

        // multiply with  suffix
        for(int i=nums.length-1; i>=0; i--){
            res[i] *= suf;
            suf *= nums[i];
        }

        return res;

    }
  
  

}
