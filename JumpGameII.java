public class Solution {
    public int jump(int[] nums) {
        int maxReach = nums[0];
        int currReach = 0;
        int minSteps = 0;
        if (nums.length == 1) return 0;
        for (int i = 1; i < nums.length; ++ i) {
            if (i > currReach) {
                minSteps++;
                currReach = maxReach;
                if (currReach >= nums.length - 1)
                    return minSteps;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
        }
        return minSteps;
    }
}
