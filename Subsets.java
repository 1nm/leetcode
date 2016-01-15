public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(nums, result, new HashSet<Integer>(), 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, Set<Integer> curr, int i) {
        result.add(new ArrayList<Integer>(curr));
        while (i < nums.length) {
            curr.add(nums[i]);
            backtracking(nums, result, curr, i + 1);
            curr.remove(nums[i]);
            i ++;
        }
    }
}
