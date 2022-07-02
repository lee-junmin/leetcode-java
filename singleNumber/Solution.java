package singleNumber;

// TC O(n) SC O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i: nums){
            res = res ^ i;
        }
        return res;
    }
}