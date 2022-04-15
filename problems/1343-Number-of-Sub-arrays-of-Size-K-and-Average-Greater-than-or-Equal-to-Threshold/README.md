# 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
- Difficulty: Medium
- Acceptance: 67.8% (as of 2022-03-14)

## Solutions
1. Sliding window, time O(n), space O(k)
   * Keep a sliding window of size k and its sum, increase the count if the average is greater than or equal to threshold.