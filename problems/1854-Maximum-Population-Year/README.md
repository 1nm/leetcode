# 1854. Maximum Population Year
- Difficulty: Easy
- Acceptance: 58.6% (as of 2022-03-14)

## Solutions
   1. Prefix sum, time O(n), space O(1)
      * Keep a prefix sum array, for each log increase the prefix at the year
      * Sum to get current population, update the max population and max year if we find a larger population