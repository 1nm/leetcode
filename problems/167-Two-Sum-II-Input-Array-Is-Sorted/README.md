# 167. Two Sum II - Input Array Is Sorted
- Difficulty: Medium
- Acceptance: 58.4% (as of 2022-03-14)

## Ideas

Read the problem description carefully, result array is the 1-based index.

1. Binary search, O(n * logn) time complexity, O(1) space complexity
   * For each element numbers[i], binary search [i + 1, len) for `target - numbers[i]`

2. Two pointers, O(n) time complexity, O(1) space complexity
   * Starting from 0 and len - 1, increase the left pointer if sum is less than the target or decrease the right pointer if sum is greater than the target