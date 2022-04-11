# 1845. Seat Reservation Manager
- Difficulty: Medium
- Acceptance: 60.0% (as of 2022-03-14)

## Solutions
1. Min heap
   * Keep a min heap of unreserved seats, when reserving a new seat, pop the min if there is any, or increase the current min seat.
   * Time complexity, reserve O(1), unreserve O(logn), space comlexity O(n)