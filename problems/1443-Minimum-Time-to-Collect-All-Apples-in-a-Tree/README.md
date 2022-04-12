# 1443. Minimum Time to Collect All Apples in a Tree
- Difficulty: Medium
- Acceptance: 55.5% (as of 2022-03-14)

## Solutions
1. DFS, time O(n), space O(e)
   * Starting from the root node 0, find all unvisited adjacent nodes in a DFS manner.
   * If current node has an apple or its adjacent nodes have apples, we need 2 more steps to collect it from the previous node.
   * If root node has an apple we need 0 steps to collected it.