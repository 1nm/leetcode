# 376. Wiggle Subsequence
- Difficulty: Medium
- Acceptance: 44.6% (as of 2022-03-14)

## Solutions
1. Dynamic Programming
   * Let inc[i] be the length of the longest wiggle subsequence that is strictly increasing at index i. dec[i] for that descreases at index i.
   * inc[i] = inc[i-1], dec[i] = dec[i-1] if equal (nums[i] == nums[i-1])
   * inc[i] = dec[i-1] + 1, dec[i] = dec[i-1] if increase (nums[i] > nums[i-1])
   * dec[i] = inc[i-1] + 1, inc[i] = inc[i-1] if decrease (nums[i] < nums[i-1])