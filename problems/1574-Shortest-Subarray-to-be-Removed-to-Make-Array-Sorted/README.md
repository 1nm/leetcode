# 1574. Shortest Subarray to be Removed to Make Array Sorted
- Difficulty: Medium
- Acceptance: 35.3% (as of 2022-03-14)

## Solutions
1. Sliding window, time O(n), space O(1)
   * To remove a sub array and make rest of the array sorted, there are only three patterns:
     1. Remove from 0 to p
     1. Remove from q to len - 1
     1. Remove from i + 1 to j - 1, concat [0, i] and [j, len - 1], where 0 <= i <= p, q <= j <= len - 1 and arr[i] <= arr[j]
   * Find p, q that [0, p] and [q, len - 1] are non-descreasing
   * Keep a sliding window i, j that 0 <= i <= p, q <= j <= len - 1 and arr[i] <= arr[j], find min length of window