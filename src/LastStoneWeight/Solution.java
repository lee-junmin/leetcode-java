package LastStoneWeight;
/*
*
* building a heap from an array will take T O(nlogn) S O(n)
* */
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int lastStoneWeight(int[] stones) {
    // create a max heap that holds the values
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    for (int stone: stones) {
      maxHeap.offer(stone);
    }
    
    
    while (maxHeap.size() > 1) {
      int stone1 = maxHeap.poll();
      int stone2 = maxHeap.poll();
      if (stone1 != stone2) {
        maxHeap.offer(Math.abs(stone1 - stone2));
      }
      
      
    }
    if (maxHeap.size() == 1){
      return maxHeap.peek();
    } else {
      return 0;
    }
    
    
    
  }
}
