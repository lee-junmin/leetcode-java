package maxProductSubarray;

// TC O(n) SC O(1) where n is the length of nums

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        int max = nums[len-1];
        int min = nums[len-1];
        int maxSoFar = max;

        for (int i=len-2; i>=0; i--){
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(curr * max, curr * min));
            min = Math.min(curr, Math.min(curr * max, curr * min));
            max = temp;
            maxSoFar = Math.max(maxSoFar, max);

        }
        return maxSoFar;

    }
}
