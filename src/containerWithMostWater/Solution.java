package containerWithMostWater;
// T O(n) S O(1)
public class Solution {
  public int maxArea(int[] height) {
    
    int l = 0;
    int r = height.length-1;
    
    int maxSoFar = 0;
    
    while (l<r){
      int width = r - l;
      int vol = width * Math.min(height[l], height[r]);
      maxSoFar = Math.max(maxSoFar, vol);
      
      if (height[l] < height[r]){
        l++;
      } else {
        r--;
      }
    }
    
    return maxSoFar;
  }
}
