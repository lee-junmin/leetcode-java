package houseRobber;
import java.util.Arrays;

public class HouseRobber {
	
	/*==================================================================

	DP approach 1 - brute force recursion

	recursion:
	we can run the recursive function for each subarray
	but we have two options
	first option is to start at index 0 and add that to the subarray starting with index 2 
	second option is to start at index 1 and 
	the max sum will be the larger one out of the two

	base case:
	when input array is empty or has 1 element

	TC 2^n SC n

	*/
	
	public static int rob1(int[] nums) {
		
		int numsLength = nums.length;
		
		if (numsLength == 0) return 0;
		if (numsLength == 1) return nums[0];
		
		int option1 = nums[0] + rob1(Arrays.copyOfRange(nums,2,numsLength));
		int option2 = rob1(Arrays.copyOfRange(nums,1,numsLength));
		
		return Math.max(option1,option2);
	}
	

	/*==================================================================
	
	DP approach 2 - Top down DP with memoization
	
	this will reduce computation by taking notes of the results that repeat during the recursion
	TC O(n) SC O(n)
	
	*/
	
	public static int rob2(int[] nums, int[] memo) {
		
		int numsLength = nums.length;
		
		if (numsLength == 0) return 0;
		if (numsLength == 1) return nums[0];
		
		if (memo[numsLength-1] != -1) return memo[numsLength-1];
		
		int option1 = nums[0] + rob2(Arrays.copyOfRange(nums,2,numsLength),memo);
		int option2 = rob2(Arrays.copyOfRange(nums,1,numsLength),memo);
		
		int result = Math.max(option1, option2);
		memo[numsLength-1] = result;
		
		return result;
	}
	
	public static int rob2(int[] nums) {
		
		int[] memo = new int[nums.length];
		for (int i=0; i<nums.length; i++) memo[i] = -1;
		
		return rob2(nums,memo);
	}
	
	/*==================================================================
	
	DP approach 3 - Bottom up approach
	in this particular problem we will start thinking from the beginning not the end of the cases
	TC O(n) SC O(n)
	
	*/
	
	public static int rob3(int[] nums) {
		int length = nums.length;
		// create an array that can hold the max up until current index
		int[] rec = new int[length];
		
		// if there is only one element in nums
		if (length == 1) return nums[0];
		
		// if there are more than 2 elements in nums
		// up until index 0 the max would be it's value
		rec[0] = nums[0];
		// up until index 1 of nums the max would be the larger of index 0 and 1
		// these two initializations can be included in the loop below, 
		// but for readability this is easier to understand of the rec and nums indices are aligned
		rec[1] = Math.max(nums[0], nums[1]);
		
		// starting from index 2 
		for (int i=2; i<length; i++) {
			rec[i] = Math.max(nums[i] + rec[i-2], rec[i-1]);
		}
		
		return rec[length-1];
				
		
	}
	
	/*==================================================================
	
	DP approach 4 - Bottom up approach with space optimization
	we only need the recent two records, so we will replace the 
	TC O(n) SC O(1)
	
	*/
	
	public static int rob4(int[] nums) {
		
		int len = nums.length;
		
		if (len == 1) return nums[0];
		
		// these are the two records we will store. 
		// we can directly init here the two variables as below
		//int before = nums[0];
		//int current = Math.max(nums[0], nums[1]);
		// but they can also be included in the loop
		
		int before = 0;
		int current = 0;
		
		for (int i=0; i<len; i++) {
			int temp = before;
			before = current;
			current = Math.max(current, temp + nums[i]);
		}
		return current;
		
	}
	
	
	
	public static void main(String[] args) {
		
		int input[] = {2, 7, 9, 3, 1};
		System.out.println(rob1(input));
		System.out.println(rob2(input));
		System.out.println(rob3(input));
		System.out.println(rob4(input));
		
	}

}







