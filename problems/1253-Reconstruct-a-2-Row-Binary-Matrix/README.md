# 1253. Reconstruct a 2-Row Binary Matrix
- Difficulty: Medium
- Acceptance: 43.1% (as of 2022-03-14)

## Solutions
  1. Greedy
     * There are only 3 different values in `colsum`
     * If sum is 0, add `0` to both lists.
     * If sum is 1, either `upper` or `lower` must be greater than `0`, decrease the large one between `upper` and `lower` and add `1` to that list.
     * If sum is 2, both `upper` and `lower` must be greater than `0`, decrease `upper` and `lower`, add `1` to both lists.
     * At the end, `upper` and `lower` must be both `0`.