public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxarea = 0;
        while (left < right) {
            int temp = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
            maxarea = temp > maxarea ? temp : maxarea;
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return maxarea;
    }
}
