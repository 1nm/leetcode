# 713. Subarray Product Less Than K
- Difficulty: Medium
- Acceptance: 43.3% (as of 2022-03-14)

## Ideas

1. Sliding window
  * find all sliding windows of [i, j] that product[i, j] is less than k
  * for such sliding window, add `j - i + 1` to the count because we know that the products of [i], [i, i + 1], ..., [i, i +  1, ..., j] are all less than k