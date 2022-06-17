package productOfArrayExceptSelf;

import java.util.Arrays;

<<<<<<< HEAD
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
=======
class Solution {

    // 1  2  3  4
    // 1  1  2  6
    // 24 12 8  6

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        res[0] = 1;

        for (int i=1; i<len; i++){
            res[i] = nums[i-1] * res[i-1];
        }

        int behind = nums[len-1];

        for (int i = len-2; i >= 0; i--){
            res[i] = res[i] * behind;
            behind *= nums[i];
        }

        return res;
    }
}
>>>>>>> c57bc7df8c3e9f5873419b75a35fb066f1e2dd5c
