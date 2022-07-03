// TC O(n) where n is the length of heights
// SC O(n) for the stack

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxSoFar = 0;
        stack.push(-1);
        for (int i=0; i<=heights.length; i++){
            int currHeight = 0;
            if (i != heights.length) currHeight = heights[i];
            while (stack.peek() != -1 && currHeight < heights[stack.peek()]){
                int poppedIndex = stack.pop();
                maxSoFar = Math.max(maxSoFar, heights[poppedIndex] * (i - poppedIndex));
            }
            stack.push(i);
        }
        return maxSoFar;
    }
}