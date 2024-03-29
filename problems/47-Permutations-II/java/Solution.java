public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums, 0, new boolean[nums.length], new LinkedList<Integer>(), result);
        return result;
    }

    private void permute(int[] nums, int index, boolean[] used, LinkedList<Integer> curr, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; ++ i) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                curr.add(nums[i]);
                used[i] = true;
                permute(nums, index + 1, used, curr, result);
                used[i] = false;
                curr.removeLast();
            }
        }
    }
}
