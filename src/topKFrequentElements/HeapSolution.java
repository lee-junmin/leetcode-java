package topKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


// TC O(n log k) where n is the length of nums, k is k
// SC O(n+k) n is the map and k is the heap

public class HeapSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n: nums){
            freq.put(n,freq.getOrDefault(n,0) + 1);
        }

        Queue<Integer> topFreqHeap = new PriorityQueue<>(
                (x,y) -> freq.get(x) - freq.get(y));

        for (int i: freq.keySet()){
            topFreqHeap.add(i);
            if (topFreqHeap.size() > k){
                topFreqHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++){
            res[i] = topFreqHeap.poll();
        }

        return res;
    }
}
