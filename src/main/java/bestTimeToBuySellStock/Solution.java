package bestTimeToBuySellStock;


class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;

        // 7 1 5 3 6 4
        // l r


        int l = 0;
        int r = 1;

        // r will iterate through
        while ( r < prices.length) {
            int profit = prices[r] - prices[l];
            max = Math.max(max, profit);
            r++;
            if (profit < 0) {
                l = r - 1;
            }
        }
        return max;
    }

}
