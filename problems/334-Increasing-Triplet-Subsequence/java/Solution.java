public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] <= min) min = nums[i];
            else if (nums[i] < min1) min1 = nums[i];
            else if (nums[i] > min1) return true;
        }
        return false;
    }
}