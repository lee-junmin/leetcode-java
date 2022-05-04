package nthTribonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class nthTribonacciTopDown {
  Map<Integer, Integer> memo;
  
  public int tribonacci(int n) {
    memo = new HashMap<>();
    memo.put(0,0);
    memo.put(1,1);
    memo.put(2,1);
    return gen(n);
    
  }
  
  private int gen(int i){
    if(memo.containsKey(i)) return memo.get(i);
    
    int result = gen(i-3) + gen(i-2) + gen(i-1);
    memo.put(i,result);
    return result;
  }
}
