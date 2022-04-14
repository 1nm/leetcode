# 1337. The K Weakest Rows in a Matrix
- Difficulty: Easy
- Acceptance: 72.2% (as of 2022-03-14)

## Solution

1. Heap (PriorityQueue)
   * Keep a min heap of the pair (sum, index) with a custom comparator