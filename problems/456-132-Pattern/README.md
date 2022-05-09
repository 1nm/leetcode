# 456. 132 Pattern
- Difficulty: Medium
- Acceptance: 30.9% (as of 2022-03-14)

## Solutions
1. Brute force, O(n ^3), O(1)
    - For any three numbers, check if we can find nums[i] < nums[k] < nums[j]

2. Monotonic Stack, O(n), O(n)
   * Scan from right to left
   * Keep a non-increasing stack, pop all the elements that smaller or equals the current element
   * Any popped element is a candiate of num[k], we keep a maximum of num[k]
   * Stack top is the num[j], so we have num[k] < num[j]
   * If we find any num[i] < num[k], we have a solution