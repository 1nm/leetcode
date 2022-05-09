class Solution {
  public boolean find132pattern(int[] nums) {
    // Scan from right to left
    // Keep a non-increasing stack, pop all the elements that smaller or equals the current element
    // Any popped element is a candiate of num[k], we keep a maximum of num[k]
    // Stack top is the num[j], so we have num[k] < num[j]
    // If we find any num[i] < num[k], we have a solution
    int maxNumJ = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < maxNumJ) {
        return true;
      } else {
        while (!stack.isEmpty() && stack.peek() < nums[i]) {
          maxNumJ = Math.max(maxNumJ, stack.pop());
        }
        stack.push(nums[i]);
      }
    }
    return false;
  }
}
