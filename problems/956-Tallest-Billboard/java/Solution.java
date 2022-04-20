import java.util.Arrays;

public class Solution {
  public int tallestBillboard(int[] rods) {
    // 2D dp
    // Let dp[i][diff] be the max height of the rods we can get with the [0, i) rods, with the j =
    // left - right + 5000, note that the max difference may be 5000 so we add 5000 to make diff >=
    // Apparently dp[0][5000] = 0
    // dp[i][j] = max(dp[i - 1][j - rods[i]] + rods[i], dp[i - 1][j + rods[i]] + rods[i], dp[i
    // -1][j])
    // return dp[len][5000] / 2
    int[][] dp = new int[rods.length + 1][10001];
    for (int[] row : dp)
      Arrays.fill(row, Integer.MIN_VALUE);
    dp[0][5000] = 0;
    for (int i = 1; i <= rods.length; i++) {
      for (int j = 0; j <= 10000; j++) {
        int max = Integer.MIN_VALUE;
        if (j - rods[i - 1] >= 0) {
          max = Math.max(max, dp[i - 1][j - rods[i - 1]] + rods[i - 1]);
        }
        if (j + rods[i - 1] <= 10000) {
          max = Math.max(max, dp[i - 1][j + rods[i - 1]] + rods[i - 1]);
        }
        max = Math.max(dp[i - 1][j], max);
        dp[i][j] = max;
      }
    }
    return dp[rods.length][5000] / 2;
  }
}
