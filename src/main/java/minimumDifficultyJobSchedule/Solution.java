package minimumDifficultyJobSchedule;
// TC (d*(n-d)^2) SC O(n*d)
public class Solution {
  
  public int minDifficulty(int[] jobDifficulty, int d) {
    
    int len = jobDifficulty.length;
    if (len < d) return -1;
    
    int[][] memo = new int[d][len];
    
    //set last day
    int maxSoFar = -1;
    for (int i=len-1; i>=0; i--){ // TC O(n) where n is the length of jobDifficulty
      memo[d-1][i] = Math.max(jobDifficulty[i], maxSoFar);
      maxSoFar = memo[d-1][i];
    }
    
    for (int currDay=d-2; currDay>=0; currDay--){ // TC  O(d * n-d * n-d)
      for (int currIndex=currDay; currIndex <= len-(d  - currDay); currIndex++){
        int dayHigh = -1;
        int sumMin = Integer.MAX_VALUE;
        for(int i=currIndex; i<=len-(d - currDay); i++){
          dayHigh = Math.max(dayHigh, jobDifficulty[i]);
          sumMin = Math.min(sumMin,dayHigh + memo[currDay+1][i+1]);
        }
        memo[currDay][currIndex] = sumMin;
        
      }
    }
    return memo[0][0];
  }
}
