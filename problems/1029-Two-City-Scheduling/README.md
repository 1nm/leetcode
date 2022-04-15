# 1029. Two City Scheduling
- Difficulty: Medium
- Acceptance: 60.0% (as of 2022-03-14)

## Solutions
1. Greedy + Sorting
   * Calculate the cost if we send all people to city A.
   * Calculate the diff cost if we send people to city B. costA - costB, the higher the better because it is the cost we can reduce by sending this people to city B.
   * Sort the diff descendingly.
   * Substract the first n diff cost from the sum.