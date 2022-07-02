package distinctSubsequence;
// TC O(mxn) where m,n is the length of s and t
// SC O(mxn)
public class SolutionIter {
        public int numDistinct(String s, String t) {

            int mainLen = s.length();
            int subLen = t.length();
            int[][] dp = new int[mainLen + 1][subLen + 1];

            for (int i=0; i < dp.length; i++){
                dp[i][subLen] = 1;
            }

            for (int i=0; i < dp[0].length - 1; i++){
                dp[mainLen][i] = 0;
            }

            for (int mIndex = mainLen - 1; mIndex >= 0; mIndex--){
                for (int sIndex = subLen - 1; sIndex >= 0; sIndex--){
                    dp[mIndex][sIndex] = dp[mIndex  + 1][sIndex];
                    if (s.charAt(mIndex ) == t.charAt(sIndex)) {
                        dp[mIndex ][sIndex] += dp[mIndex  + 1][sIndex + 1];
                    }
                }
            }

            return dp[0][0];

        }

}
