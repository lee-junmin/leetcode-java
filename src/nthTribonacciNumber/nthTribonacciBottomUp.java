package nthTribonacciNumber;

public class nthTribonacciBottomUp {
  
  public int tribonacci(int n) {
    
    int downOne = 1; // n=2
    int downTwo = 1; // n=1
    int downThree = 0; // n=0
    
    if (n == 0) return 0;
    if (n == 1 || n == 2) return 1;
    
    for (int i = 3; i < n + 1; i++) {
      int temp = downOne;
      downOne = downOne + downTwo + downThree;
      downThree = downTwo;
      downTwo = temp;
      
    }
    
    return downOne;
  
  }
}
