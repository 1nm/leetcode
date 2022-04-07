# 2202. Maximize the Topmost Element After K Moves
- Difficulty: Medium
- Acceptance: 19.4% (as of 2022-03-14)

## Solutions

1. Find the max O(n)
   * If there is only one element in array and k is an odd number, we cannot get a non-empty array
   * If k > nums.length it's simply find max number in array
   * If k <= nums.length we can't make nums[k - 1] the topmost because we need k steps to take this number, but we can make nums[k] the topmost by removing all [0, k - 1] numbers