# 1147. Longest Chunked Palindrome Decomposition
- Difficulty: Hard
- Acceptance: 60.2% (as of 2022-03-14)

## Solutions
   1. Two pointers and greedy, time O(n), space O(n)
      * Scan the string with two pointers, starting from the beginning and the end respectively, if we find a equal, we find a chunked palindrome and increase the count by 2
      * If we cannot find any chunked palindrome, the count is 1
      * Check last postion and if the string can be chunked into even number of panlindromes, reduce the count by 1