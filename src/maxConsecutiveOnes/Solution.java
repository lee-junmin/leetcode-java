package maxConsecutiveOnes;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSoFar = 0;
        int currMax = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 1){
                currMax++;
            } else {
                currMax = 0;
            }
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
