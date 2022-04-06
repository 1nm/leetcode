# 3. Longest Substring Without Repeating Characters
- Difficulty: Medium
- Acceptance: 32.9% (as of 2022-03-14)

## Solutions
1. Sliding window
   * Keep track of a sliding window that does not contain repeating characters, and the index of the characters that appeared.
   * If found a repeating character, update max if the length of the current window is larger
   * Set the start of the window to the index of the repeating character + 1