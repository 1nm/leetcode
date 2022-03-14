public class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        } else {
            return Math.max(rob(nums, 1, nums.length), rob(nums, 0, nums.length - 1));
        }
    }

    private int rob(int[] nums, int start, int end) {
        int length = end - start;
        if (length < 2) {
            return length <= 0 ? 0 : nums[start];
        }
        int[] max = new int[length];
        max[0] = nums[start];
        max[1] = nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
        for (int i = 2; i < length; i++) {
            max[i] = max[i - 2] + nums[i + start] > max[i - 1] ? max[i - 2] + nums[i + start] : max[i - 1];
        }
        return max[max.length - 1];
    }
}
