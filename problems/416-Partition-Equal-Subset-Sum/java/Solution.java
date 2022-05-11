class Solution {
  public boolean canPartition(int[] nums) {
    // Let dp[i][diff] be true if we can divide first i elements to two groups where their sums has
    // the diff.
    // Note that the max diff is 200 * 100 = 20000 and it ranges from -20000 to 20000
    // since we cannot use negative number as the index, we use [0, 40000], 20000 means the diff is
    // 0, so we have dp[0][20000] = true
    // dp[i + 1][j] = dp[i][j - nums[i]] || dp[i][j + nums[i]]
    // max diff can be reduced to the sum of the array
    int MAX_DIFF = 20000;
    boolean[][] dp = new boolean[nums.length + 1][MAX_DIFF * 2 + 1];
    dp[0][MAX_DIFF] = true;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j <= MAX_DIFF * 2; j++) {
        if (j - nums[i] >= 0 && dp[i][j - nums[i]]) {
          dp[i + 1][j] = true;
        }
        if (j + nums[i] <= MAX_DIFF * 2 && dp[i][j + nums[i]]) {
          dp[i + 1][j] = true;
        }
      }
    }

    return dp[nums.length][MAX_DIFF];
  }
}
