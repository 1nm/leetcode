# 996. Number of Squareful Arrays
- Difficulty: Hard
- Acceptance: 49.1% (as of 2022-03-14)

## Ideas

1. Backtracking, O(n!)
   * Trickest part is how to deduplicate from the backtracking results
   * Sort the array, skip the processing if the previous element has the same value but not visited (because the previous element must have been visited)