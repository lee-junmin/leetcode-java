package kClosestPointsToOrigin;

import java.util.Queue;
import java.util.PriorityQueue;

// TC O(k log n) where k is input k and n is the length of points
// SC O(k)

    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
            int[][] result = new int[k][2];
            for (int i=0; i<points.length; i++){
                int squareDistance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                int[] pair = new int[]{squareDistance, i};
                if (maxHeap.size() < k){
                    maxHeap.offer(pair);
                } else if (maxHeap.peek()[0] > pair[0]) {
                    maxHeap.poll();
                    maxHeap.offer(pair);
                }
            }

            for (int i=0; i<k; i++){
                int[] polled = maxHeap.poll();
                result[i] = points[polled[1]];
            }

            return result;
        }
    }

