package coinChange;

import java.util.Arrays;
// where a is amount and N is the length of coins
//TC O(a*N)
//SC O(a)

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        for (int subAmount=0; subAmount<=amount; subAmount++) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++){
                int prev = subAmount - coins[j];
                if (prev >= 0 && memo[prev] != -1) {
                    min = Math.min(min, memo[prev]);
                    memo[subAmount] = min + 1;
                }
            }

        }
        return memo[amount];
    }
}
