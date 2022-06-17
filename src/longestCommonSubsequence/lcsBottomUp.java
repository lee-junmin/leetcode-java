package longestCommonSubsequence;
// TC & SC O(M*N) where m is the length of text1, and n length of text2
public class lcsBottomUp {
  public int longestCommonSubsequence(String text1, String text2) {
    int len1 = text1.length();
    int len2 = text2.length();
    int[][] memo = new int[len1+1][len2+1];
    for (int i=0; i<len1; i++){
      for(int j=0; j<len2; j++){
        memo[i][j] = -1;
      }
    }
    
    for (int c1=len1-1; c1>=0; c1--){
      for (int c2=len2-1; c2>=0; c2--){
        
        if (text1.charAt(c1) == text2.charAt(c2)) {
          memo[c1][c2] = memo[c1+1][c2+1] + 1;
        } else {
          memo[c1][c2] = Math.max(
            memo[c1+1][c2],
            memo[c1][c2+1]
          );
        }
      }
    }
    
    return memo[0][0];
  }
}
