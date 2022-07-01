package distinctSubsequence;
// TC O(mxn) where m and s are the length of s and t
// SC O(n) where n is length of t
public class SolutionSpaceOptIter {
    public int numDistinct(String s, String t) {

        int mainLen = s.length();
        int subLen = t.length();
        int[] dp = new int[subLen];

        for (int mIndex = mainLen - 1; mIndex >= 0; mIndex--){
            int toAdd = 1; // 1 for first match
            for (int sIndex = subLen - 1; sIndex >= 0; sIndex--){
                int temp = dp[sIndex];
                if (s.charAt(mIndex) == t.charAt(sIndex)) dp[sIndex] += toAdd;
                toAdd = temp;
            }
        }
        return dp[0];
    }
}
