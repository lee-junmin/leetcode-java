package minimumSizeSubarraySum;
// TC O(n) where n is the length of nums. one-pass with 2 pointers
// SC O(1) no additional space allocated. constant space for the variables.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;
        int headIndex = 0;
        int currSum = 0;
        int minSoFar = len;

        for (int tailIndex=0; tailIndex<len; tailIndex++){
            currSum += nums[tailIndex];
            if (currSum >= target) {
                while (currSum >= target){
                    minSoFar = Math.min(minSoFar, tailIndex - headIndex + 1);
                    currSum -= nums[headIndex];
                    headIndex++;
                }
            }
        }
        return headIndex == 0 ? 0 : minSoFar;

    }
}
