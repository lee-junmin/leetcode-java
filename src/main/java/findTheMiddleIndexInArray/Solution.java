package findTheMiddleIndexInArray;
//TC O(n)
// SC O(1)
public class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        int sumSoFar = 0;
        for (int i: nums){
            totalSum += i;
        }

        for (int i=0; i<nums.length; i++){
            if (sumSoFar == totalSum - nums[i] - sumSoFar){
                return i;
            }
            sumSoFar += nums[i];
        }

        return -1;
    }
}
