public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++ i) {
            maxEndingHere = maxEndingHere + nums[i] > nums[i] ? maxEndingHere + nums[i] : nums[i];
            max = maxEndingHere > max ? maxEndingHere : max;
        }
        return max;
    }
}