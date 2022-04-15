
/*

SUMMARY
keep on adding the sum with no carry (a XOR b), and value with only carry (a AND b) << 1.
reassign each to a and b and loop until b becomes 0

MAIN IDEA
for each position the sum can either be
case 1. 0,  when a=0 b=0
case 2. 1,  when a=1 b=0 or a=0 b=1
case 3. 10, when a=1 b=1
if you just think about the last position of the result,
this can be a XOR result of each position for a and b

but we need to think about the carry value for case 3
there is a carry value only when a=1 AND b=1
we can add (a AND b and bit shift left once) to the result to reflect the carry value

the adding of the carry value should go on until there is no carry value to add

to make the code simpler for each loop we will
re-assign a to a XOR b
re-assign b to the carry value to be added
and keep on looping until b becomes 0


  0010 a
  0011 b
  ----
  0001 (XOR) a
 00100 (AND and <<) b
  ----
 00101 a
00000  b when b is 0 the return a

O(logb) O(1)


 */

package sumOfTwoIntegers;

public class Solution {
  public int getSum(int a, int b) {
    while (b != 0){
      int temp = a;
      a = a ^ b;
      b = (temp & b) << 1;
    }
    return a;
  }
  
  // recursive solution
  public int getSum_r(int x, int y){
    if (y == 0)
      return x;
    else
      return getSum_r(x ^ y, (x & y) << 1);
  }
  
  
  public static void main (String[] args){
    Solution s = new Solution();
    int answer = s.getSum(3,4);
    System.out.println(answer);
    
  }
}
