# 443. String Compression
- Difficulty: Medium
- Acceptance: 47.3% (as of 2022-03-14)

## Solutions
1. Straight-forward solution, time O(n), space O(1)
   * Keep track of the current position of the inline update
   * Count the repeating characters and inline update the character. If the count is greater than 1, inline append the string of the count
   * Return the length of the compressed string