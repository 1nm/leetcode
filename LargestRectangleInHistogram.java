public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] newHeight = new int[height.length + 2];
        int[] left = new int[height.length + 2];
        int[] right = new int[height.length + 2];
        newHeight[0] = newHeight[height.length] = -1;
        System.arraycopy(height, 0, newHeight, 1, height.length);

        for (int i = 1; i <= height.length; ++ i) {
            left[i] = newHeight[i] <= newHeight[i - 1] ? left[i - 1] + 1 : 0;
        }

        for (int i = height.length; i >= 1; -- i) {
            right[i] = newHeight[i] <= newHeight[i + 1] ? right[i + 1] + 1 : 0;
        }

    }
}
