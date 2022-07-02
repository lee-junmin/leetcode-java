package houseRobber2;
// TC O(n) SC O(1)
class Solution {
    public int rob(int[] nums) {

        int len = nums.length;
        if (len == 1) return nums[0];
        return Math.max(maxSub(nums,0,len-2), maxSub(nums,1,len-1));

    }

    private int maxSub(int[] nums, int start, int end){
        int oneBack = 0;
        int twoBack = 0;

        for (int i=start; i<=end; i++){
            int curr = 0;
            curr = Math.max(oneBack, nums[i] + twoBack);

            twoBack = oneBack;
            oneBack = curr;
        }

        return oneBack;
    }
}
