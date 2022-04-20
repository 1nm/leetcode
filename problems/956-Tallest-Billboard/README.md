# 956. Tallest Billboard
- Difficulty: Hard
- Acceptance: 39.9% (as of 2022-03-14)

## Solutions
  1. DP, time O(sum * n), space O(sum * n)
     * Let `dp[i][j]` be the max height of the rods we can get with the `[0, i)` rods, where `j = diff + 5000`, note that `diff` ranges from `-5000` to `5000` so we add `5000` to make `j >= 0`.
    * Apparently we have `dp[0][5000] = 0`
    * `dp[i][j] = max(dp[i - 1][j - rods[i]] + rods[i], dp[i - 1][j + rods[i]] + rods[i], dp[i - 1][j])`
    * return `dp[len][5000] / 2`
    * can be optimized to O(sum) time and space