# 522. Longest Uncommon Subsequence II
- Difficulty: Medium
- Acceptance: 40.1% (as of 2022-03-14)

## Solutions
1. Two pointers, time O(n^2 * m), space O(1)
   * Use two pointers to check if a string is the subsequence of another string
   * Compare each pair of strings, if a string is not the subsequence of any other string, update longest if its length is longer than the current longest