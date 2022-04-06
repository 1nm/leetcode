# 729. My Calendar I
- Difficulty: Medium
- Acceptance: 55.0% (as of 2022-03-14)

## Solutions

1. Keep a sorted list of intervals
   * find floor and ceiling of the interval in list
   * insert new interval if it doesn't overlap with existing intervals
   * Time complexity O(n * logn), space complexity O(n)