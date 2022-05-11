# 416. Partition Equal Subset Sum
- Difficulty: Medium
- Acceptance: 46.3% (as of 2022-03-14)

## Solutions
   0/1 Knapsack problem, dynamic programming
   * Let dp[i][diff] be true if we can divide first i elements to two groups where their sums has the diff.
   * Note that the max diff is 200 * 100 = 20000 and it ranges from -20000 to 20000
   * since we cannot use negative number as the index, we use [0, 40000], 20000 means the diff is 0, so we have dp[0][20000] = true
   * dp[i + 1][j] = dp[i][j - nums[i]] || dp[i][j + nums[i]]
   * max diff can be reduced to the sum of the array