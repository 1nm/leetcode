public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dpmin = new int[nums.length];
        int[] dpmax = new int[nums.length];
        dpmin[0] = dpmax[0] = nums[0];
        int max = dpmax[0];
        for (int i = 1; i < nums.length; ++ i) {
            dpmin[i] = Math.min(nums[i], Math.min(dpmax[i - 1] * nums[i], dpmin[i - 1] * nums[i]));
            dpmax[i] = Math.max(nums[i], Math.max(dpmax[i - 1] * nums[i], dpmin[i - 1] * nums[i]));
            if (max < dpmax[i]) {
                max = dpmax[i];
            }
        }
        return max;
    }
}