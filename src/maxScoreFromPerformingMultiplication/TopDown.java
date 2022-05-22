package maxScoreFromPerformingMultiplication;

public class TopDown {

  int[] nums;
  int[] multipliers;
  int n;
  int m;
  int[][] memo;

  public int maximumScore(int[] nums, int[] multipliers) {
    this.nums = nums;
    this.multipliers = multipliers;
    n = nums.length;
    m = multipliers.length;
    memo = new int[m][m];
    return genScore(0, 0);
  }

  private int genScore(int i, int left) {
    if (i == m) return 0;

    int right = n - 1 - (i - left);
    int mul = multipliers[i];


    if (memo[i][left] == 0) {
      memo[i][left] = Math.max(mul * nums[left] + genScore(i + 1, left + 1),
              mul * nums[right] + genScore(i + 1, left));
    }

    return memo[i][left];
  }
}