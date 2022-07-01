package numberOfOneBits;
/*

use bit shifting to move to the next position
bit shifting is very cpu efficient
we'll stop when everything becomes 0

1) do a bitwise & operation of 1 for each position
2) mod by 2 for each position
3) better computation: the number of times n = n && (n-1) can be done until n turns into 0 will also be the answer
minus 1 to an integer will either take away a 1,
or take away a 1 at the head and introduce a series of 1s for the rest
--> this will make everything 0 (11000 --> 10111)

4) in java you can simply return Integer.bitCount(n);

TC is O(1) because the input is always 32bits
SC is also O(1)
 */
public class NumberOfOneBits {
  // approach 2 using modulus
  public static int hammingWeight1(int n) {
    int result = 0;
    while (n != 0) {
    
//      if (n%2 == 1){
//       result++;
//      }
      // the below line can replace the if statement above
      result += n % 2;
       n >>= 1;
    }
    return result;
  }
  
  // approach 3 more efficient
  
  public static int hammingWeight2(int n){
    int result = 0;
    while (n != 0){
      n &= (n-1);
      result++;
    }
    return result;
  }
  
  // driver
  public static void main(String[] args){
    System.out.println(hammingWeight1(3));
    System.out.println(hammingWeight2(3));
  }
}
