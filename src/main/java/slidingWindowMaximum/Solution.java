package slidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

// TC O(n) where n is the length of nums. each element is added/removed from the deque
// SC O(k) where k is k

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deq = new LinkedList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (rightIndex < nums.length){
            int rightValue = nums[rightIndex];
            while (!deq.isEmpty() && nums[deq.peekLast()] < rightValue){
                deq.pollLast();
            }
            deq.offerLast(rightIndex);
            if (leftIndex > deq.peekFirst()) deq.pollFirst();
            if (rightIndex >= k - 1) {
                result[rightIndex - k + 1] = nums[deq.peekFirst()];
                leftIndex++;
            }

            rightIndex++;
        }

        return result;
    }
}