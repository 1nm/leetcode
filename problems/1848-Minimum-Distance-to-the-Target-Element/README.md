# 1848. Minimum Distance to the Target Element
- Difficulty: Easy
- Acceptance: 59.8% (as of 2022-03-14)

## Solutions
   1. Two pointers, time O(n), space O(1)   
      * Use two pointers to search to the left and right from the start position, if we find the target return abs(pos - start)