/*
we will loop 32 times
get each left bit by first &1 and doing a >> at the end of each loop until n is 0
when push that bit 31-i times to the left and | it to the result

 */

package nthTribonacciNumber.reverseBits;

public class ReverseBits {
  
  public static int reverseBits(int n){
    int result = 0;
    
    for(int i=0; i<32; i++){
      int bit = n & 1;
      result |= bit << (31-i);
      n >>= 1;
    }
    return result;
  }
  
  
  
  
  public static void main (String[] args){
    System.out.println(reverseBits(43261596));
  
  }
}
