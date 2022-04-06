# 567. Permutation in String
- Difficulty: Medium
- Acceptance: 45.0% (as of 2022-03-14)

## Solutions

1. Sliding window, O(l1 + 26 * (l2 - l1)) time complexity, O(1) space complexity
   * If a string is a permutation of another, they must have the same character counter map
   * Keep a sliding window with the length of the string s1, and its character counter map. If there is a match with the counter map of s1, return true.

