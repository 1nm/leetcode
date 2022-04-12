# 1954. Minimum Garden Perimeter to Collect Enough Apples
- Difficulty: Medium
- Acceptance: 52.4% (as of 2022-03-14)

## Solutions
1. Math + binary search, time O(logx^(1/3)), space O(1), x is the number of apples

   * Let `r` be the half length of the edge

      `r = 1`
      ```
      2 1 2
      1 0 1
      2 1 2
      ```
 
     `r = 2`
     ```
     4 3 2 3 4
     3 2 1 2 3
     2 1 0 1 2
     3 2 1 2 3
     4 3 2 3 4
     ```
 
     Note that the matrix can be divided into 4 rectagles, each dimension is either `r * (r + 1)` or `(r + 1) * r`.
 
     In the example `r = 2`, the rectangle on the top right
     ```
     2 3 4
     1 2 3
     ```
 
     The rectagle on the bottom left
     ```
     3 2 1
     4 3 2
     ```
 
     By adding these two rectangles or matrixes, we can get the a rectagle with all same numbers, each value is `2 * r + 1`.
     ```
     5 5 5
     5 5 5
     ```
 
     Thus the sum of the two rectagles are `r * (r + 1) * (2 * r + 1)`.
 
     There are another two rectagles so the sum is `2 * r * (r + 1) * (2 * r + 1)`, and the perimeter is `8 * r`.

   * Since `f(r) = 2 * r * (r + 1) * (2 * r + 1)` is monotonically increasing, we can use binary search to find the `r` that `f(r) >= x` and `f(r - 1) < x`, given `x` is the number of needed apples.