public class Solution {
    public int trap(int[] height) {
        int lmax = 0, rmax = 0, max = 0;
        int l = 0, r = height.length - 1;
        while (l <= r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax)
                max += lmax - height[l++];
            else
                max += rmax - height[r--];
        }
        return max;
    }
}
