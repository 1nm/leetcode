# 1871. Jump Game VII
- Difficulty: Medium
- Acceptance: 24.7% (as of 2022-03-14)

Ideas:
1. Brute force, O(n ^ 2), TLE
   - for each position i, update dp[i + minJump, i + maxJump]
   - time complexity is O(n^2) because maxJump - minJump can be as large as n

1. Two pointers, O(n)
   - for each position i, update reachable[max(j, i + minJump), min(len, i + maxJump)]
   - j can monotonically increased, thus time complexity is O(n)

1. DP + sliding window
   - let pre be the number of possible jumps
   - for position i, count pre in the sliding window [i - maxJump, i - minJump]
   - update dp[i] to true if s[i] == '0' and pre > 0
