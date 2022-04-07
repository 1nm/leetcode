# 887. Super Egg Drop
- Difficulty: Hard
- Acceptance: 27.2% (as of 2022-03-14)


## Solutions
1. DP + Binary Search, time complexity O(k * nlogn), space complexity O(k * n)
   * We have 
   * dp[k][n] = 1 + min(for i in [1, n + 1] max(dp[k - 1][i - 1] + dp[k][n - i]))
   * binary search to find the best i