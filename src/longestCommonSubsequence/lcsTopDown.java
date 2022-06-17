package longestCommonSubsequence;

public class lcsTopDown {
  class Solution {
    
    String text1;
    String text2;
    
    int[][] memo;
    
    public int longestCommonSubsequence(String text1, String text2) {
      
      
      int len1 = text1.length();
      int len2 = text2.length();
      this.text1 = text1;
      this.text2 = text2;
      
      if (len2 == 0) return 0;
      
      memo = new int[len1+1][len2+1];
      
      for (int i=0; i<text1.length(); i++){
        for (int j=0; j<text2.length(); j++){
          memo[i][j] = -1;
        }
      }
      return genLength(0,0);
    }
    
    private int genLength(int c1, int c2){
      if(memo[c1][c2] != -1) return memo[c1][c2];
      
      char curr = text1.charAt(c1);
      int match = text2.indexOf(curr,c2);
      int ignore = genLength(c1 + 1,c2);
      int include = 0;
      if (match != -1){
        include = genLength(c1 + 1, match + 1) + 1;
      }
      
      
      return Math.max(ignore,include);
    }
  }
}
