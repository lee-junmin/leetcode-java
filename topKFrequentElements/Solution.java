package topKFrequentElements;
/*

Make a hashmap with each element as key and occurence as value
T O(n) S O(n) where n is the number of elements in nums

Then get the key of the highest value
get highest value O(k*n) where n is the number elements, worst case every element is unique

you can also use a heap.
new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());


*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> seen = new HashMap<>();
    int[] result = new int[k];
    
    for (int n: nums){
      seen.put( n , seen.getOrDefault(n,0) + 1 );
    }
    
    for (int i=0; i<k; i++){
      int highestKey = keyWithHighestValue(seen);
      result[i] = highestKey;
      seen.remove(highestKey);
    }
    
    return result;
    
  }
  
  private int keyWithHighestValue(Map<Integer,Integer> map){
    int maxV = 0;
    int maxK = 0;
    for (int i: map.keySet()){
      int curr = map.get(i);
      if ( curr > maxV) {
        maxK = i;
        maxV = curr;
      }
    }
    return maxK;
  }
}
