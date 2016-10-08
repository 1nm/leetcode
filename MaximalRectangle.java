public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m + 1];
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int k = 0; k < n; ++ k) {
            stack.clear();
            for (int l = 0; l < m; ++ l)
                height[l] = matrix[k][l] == '1' ? height[l] + 1 : 0;
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
        }
        return max;
    }
}