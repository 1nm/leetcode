# 844. Backspace String Compare
- Difficulty: Easy
- Acceptance: 47.3% (as of 2022-03-14)

## Solutions
1. Naive solution, time O(n), space O(1)
   * Scan both strings from right to left, increase the count if `#` is encountered, descrease the count and skip the next character if the count is not zero
   * Compare the characters at current index, return false if they are not equal
   * Repeat the above steps
