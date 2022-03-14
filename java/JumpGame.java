public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int max = nums[0];
        for (int i = 1; i <= max; ++ i) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}