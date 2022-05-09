# 1252. Cells with Odd Values in a Matrix
- Difficulty: Easy
- Acceptance: 78.5% (as of 2022-03-14)

## Solution
1. Brute force, time O(n * m + indices.length * (n + m)), space O(n * m)
   * Create a matrix and simulate the increment
   * Count the odd cells

2. Math, time O(indices.length), space O(n + m)
   * Keep two hash sets, toggle the row and column indices, i.e. add the row or column index if it is not in the set, remove it if it is in the set
   * `count = rows.size() * n + cols.size() * (m - rows.size()) - cols.size() * rows.size()`
