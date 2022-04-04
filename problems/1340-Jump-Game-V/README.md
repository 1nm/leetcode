# 1340. Jump Game V
- Difficulty: Hard
- Acceptance: 61.9% (as of 2022-03-14)

## Ideas
1. Bottom-up DP, O(n)
   - dp[i] is the maxmium jump if we start jumping from i
   - for any index j if we can jump from i to j, dp[i] = Max(dp[i], dp[j] + 1)
   - start calculating dp from the lowest index
