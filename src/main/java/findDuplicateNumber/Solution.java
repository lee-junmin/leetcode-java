package findDuplicateNumber;
// TC O(n) SC O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        slow = nums[0];

        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;


    }
}

//class Solution {
//    public int findDuplicate(int[] nums) {
//        while (nums[-1] != nums[nums[0]]){
//            int temp = nums[nums[-1]];
//            nums[nums[-1]] = nums[0];
//            nums[-1] = temp;
//
//        }
//        return nums[-1];
//    }
//}