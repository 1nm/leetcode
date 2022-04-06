# 1791. Find Center of Star Graph
- Difficulty: Easy
- Acceptance: 83.7% (as of 2022-03-14)

## Solutions

1. Count the degrees of each node
   * center node has n - 1 degree, while all other nodes have only 1 degree
   * simply return the first node that has more than 1 degree