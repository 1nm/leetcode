# 1640. Check Array Formation Through Concatenation
- Difficulty: Easy
- Acceptance: 55.7% (as of 2022-03-14)

## Solutions
1. Hash Map, time complexity O(n), space complexity O(n)
    * Keep a hash map of the indices of the numbers in the array
    * Remove each number from the pieces, if there are multiple numbers in one piece, the indices must be consecutive
    * If the hash map is empty, we have a solution
