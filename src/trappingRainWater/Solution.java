package trappingRainWater;
// TC O(n)  SC O(1)
class Solution {
    public int trap(int[] height) {
        int leftIndex = 0;
        int rightIndex  = height.length - 1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];
        int res  =  0;

        while (leftIndex <  rightIndex){
            if (leftMax < rightMax){
                leftIndex++;
                leftMax =  Math.max(leftMax, height[leftIndex]);
                res +=  leftMax -  height[leftIndex];
            } else {
                rightIndex--;
                rightMax = Math.max(rightMax, height[rightIndex]);
                res += rightMax - height[rightIndex];
            }
        }
        return res;
    }
}