package happyNumber;

class Solution {
  public boolean isHappy(int n) {
    int slow = n;
    int fast = getNext(n);
    
    // until fast becomes 1. happy number of 1 is 1.
    while (fast != 1){
      if (slow == fast){
        return false;
      }
      slow = getNext(slow);
      fast = getNext(getNext(fast));
    }
    
    return true;
  }
  
  private int getNext(int n){
    int res = 0;
    while (n != 0){
      int digit = n % 10;
      res += digit * digit;
      n = n / 10;
    }
    
    return res;
  }
}
//hashmap solution

//class Solution {
//  public boolean isHappy(int n) {
//    HashSet<Integer> seen  = new HashSet<>();
//    while(n != 1) {
//      n = getNext(n);
//      if (seen.contains(n)) return  false;
//      seen.add(n);
//    }
//
//    return true;
//  }
//
//  private int getNext(int n) {
//    int res = 0;
//    while (n != 0) {
//      int digit = n % 10;
//      res += digit * digit;
//      n = n / 10;
//    }
//    return res;
//  }
//}