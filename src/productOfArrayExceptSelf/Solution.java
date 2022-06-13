package productOfArrayExceptSelf;

import java.util.Arrays;

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