public class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[1];
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < max.length; i++) {
            max[i] = (max[i - 2] + nums[i]) > max[i - 1] ? (max[i - 2] + nums[i]) : max[i - 1];
        }
        return max[max.length - 1];
    }
}
