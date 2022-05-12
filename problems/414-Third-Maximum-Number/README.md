# 414. Third Maximum Number
- Difficulty: Easy
- Acceptance: 31.7% (as of 2022-03-14)

## Solutions
   1. Straight forward, time O(n), space O(1)
   * Keep the top 3 max numbers, scan the array and update the first max, second max and third max in following order:
     * If num equals any of first second or third max, do nothing because we only count distinct numbers
     * If num > first max, update third max to second max, update second max to first max and first max to num
     * If num > second max, update third max to second max and second max to num
     * If num > third max, update third max to num