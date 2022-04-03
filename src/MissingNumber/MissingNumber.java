package MissingNumber;

public class MissingNumber {
	
	/*
	 	there are 2 ways with TC O(n) SC O(1)
	 */
	
	// get the sum of the sequence and subtract the sum of the input
	public  int missingNumber1(int[] nums) {
		int n = nums.length;
		int targetSum = n * (n+1) / 2;
		int inputSum = 0;
		for (int i=0; i<nums.length; i++){
		  inputSum += nums[i];
		}
		return targetSum - inputSum;
	}
 	
	// xor everything and the remaining value will be the answer
	// xor give 0 when operands are the same
	
	public int missingNumber2(int[] nums) {
		int result = 0;
		for (int i=0; i<nums.length+1; i++) {
			result = result ^ i;
		}
		for (int i=0; i<nums.length; i++) {
			result = result ^ nums[i];
		}
		
		return result;
		
		
	}   

	public static void main(String[] args) {
		MissingNumber m = new MissingNumber();
		int[] input = {9,6,4,2,3,5,7,0,1};
		System.out.println(m.missingNumber1(input));
		System.out.println(m.missingNumber2(input));

	}
}

