public class Solution {
    public int largestRectangleArea(int[] h) {
        int[] height = new int[h.length + 1];
        System.arraycopy(h, 0, height, 0, h.length);
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i < height.length) {
            if (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int j = stack.pop();
                int area = height[j] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = max < area ? area : max;
            } else {
                stack.push(i++);
            }
        }
        return max;
    }
}