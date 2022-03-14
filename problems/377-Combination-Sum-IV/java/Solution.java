public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++ i) {
            map.put(nums[i], 1);
        }
        for (int n = 1; n <= target; ++ n) {
            int sum = map.containsKey(n) ? map.get(n) : 0;
            for (int i = 0; i < nums.length; ++ i) {
                sum += map.containsKey(n - nums[i]) ? map.get(n - nums[i]) : 0;
            }
            map.put(n, sum);
        }
        return map.get(target);
    }
}
