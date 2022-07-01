package largestNumberAtLeastTwiceOfOthers;
//TC O(n)
// SC O(1)
class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        int largest = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] >= largest){
                largest = nums[i];
                maxIndex = i;
            }
        }

        for (int i=0; i<nums.length; i++){
            if ( i != maxIndex && largest < nums[i] * 2){
                return -1;
            }
        }

        return maxIndex;

    }
}
