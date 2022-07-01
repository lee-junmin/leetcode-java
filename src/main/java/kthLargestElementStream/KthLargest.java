package kthLargestElementStream;
// SUMMARY
// make the input array into a minHeap of size k.
// add() should add and pop the val input from that heap and return the peek.


import java.util.PriorityQueue;

public class KthLargest {
  
  private static int k;
  private PriorityQueue<Integer> minHeap;
  
  public KthLargest(int k, int[] nums) {
    // init
    this.k = k;
    
    // put nums in a minHeap
    minHeap = new PriorityQueue<Integer>();
    for (int num: nums){
      minHeap.offer(num);
    }
    
    // cut the size of the minHeap to k, this is possible because we only add no removes
    
    while (minHeap.size() > k) {
      minHeap.poll();
    }
  }
  
  public int add(int val) {
    
    // add val to our heap and sift up
    minHeap.offer(val);
    
    // pop the root and keep the size k
    if (minHeap.size() > k) {
      minHeap.poll();
    }
    
    // return the root
    return minHeap.peek();
  }

  

}
