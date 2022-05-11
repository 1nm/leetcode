# 653. Two Sum IV - Input is a BST
- Difficulty: Easy
- Acceptance: 58.6% (as of 2022-03-14)

## Solutions
   1. DFS, time O(n), space O(n)
      * Use a hash table to store the visited nodes and values, traverse the nodes and see if (k - node.val) is in the hash table
      * Works for non-BSTs as well
   1. Two pointers, time O(n), space O(n)
      * Traverse the BST to get a sorted array, use two pointers to find the target
   1. Binary search, time O(n*h), space O(h)
      * For each node, use binary search to find the (k - node.val) node