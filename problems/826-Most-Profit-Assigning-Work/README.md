# 826. Most Profit Assigning Work
- Difficulty: Medium
- Acceptance: 41.3% (as of 2022-03-14)

## Solutions
1. Sort and Greedy, time O(nlogn + mlogm), space O(n)
   * Zip the difficulty and profit together as the job list, sort the job list by difficulty.
   * Sort the worker
   * Find the best profit that a worker can do and sum