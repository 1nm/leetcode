# 441. Arranging Coins
- Difficulty: Easy
- Acceptance: 45.1% (as of 2022-03-14)

## Solutions
   1. Math
      * for a full k row count `sum(k) = 1 + 2 + ... + k = k * (1 + k) / 2`
      * So we need to find k that satisfies `k * (1 + k) / 2 <= n`
      * We have the equation `(1/2) * k^2 + (1/2) * k - n <= 0`
      * Since `k` and `n` are both positive integers we have `k = floor((-b + sqrt(b^2 - 4ac)) / 2a)`