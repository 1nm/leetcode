# 396. Rotate Function
- Difficulty: Medium
- Acceptance: 39.0% (as of 2022-03-14)

## Solutions
   1. Dynamic Programming, time O(n), space O(n)
      * The hint is in the explanation, we just need to find the relations between the previous and current state
        ```
        F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
        F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
        F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
        F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
        ```
      * After observation we can know that `F[i] = F[i - 1] + sum - len * nums[len - i]`