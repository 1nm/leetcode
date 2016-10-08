public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++ i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start ++;
                    end --;
                while (start > 0 && start < end && nums[start] == nums[start - 1]) {
                    start ++;
                }
                while (end < nums.length - 1 && start < end && nums[end] == nums[end + 1]) {
                    end --;
                }
                } else if (nums[start] + nums[end] < target) {
                    start ++;
                } else {
                    end --;
                }
            }
        }
        return result;
    }
}