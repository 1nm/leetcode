public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int mindiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++ i) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int diff = nums[start] + nums[end] + nums[i] - target;
                if (Math.abs(mindiff) > Math.abs(diff)) {
                    mindiff = diff;
                }
                if (diff == 0) {
                    break;
                } else if (diff < 0) {
                    start ++;
                } else {
                    end --;
                }
            }
        }
        return target + mindiff;
    }
}
