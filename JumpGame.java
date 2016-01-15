public class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; ++ i) {
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
