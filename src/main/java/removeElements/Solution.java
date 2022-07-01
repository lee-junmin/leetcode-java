package removeElements;

// TC O(n) where n is the length of nums
// SC O(1) as we are doing in-place

class Solution {
    public int removeElement(int[] nums, int val) {
        int updateIndex = 0;
        for (int findIndex = 0; findIndex < nums.length; findIndex++){
            if (nums[findIndex] != val){
                nums[updateIndex] = nums[findIndex];
                updateIndex++;
            }
        }
        return updateIndex;
    }
}
