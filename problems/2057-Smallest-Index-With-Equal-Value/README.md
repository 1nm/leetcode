# 2057. Smallest Index With Equal Value
- Difficulty: Easy
- Acceptance: 73.6% (as of 2022-03-14)

## Solutions
   1. Straight forward, time O(n), space O(1)
      * Scan the array from index 0, return the first i that satisfies i % 10 == nums[i], if there is none return -1 at the end.