public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(nums, result, new LinkedList<Integer>(), 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, LinkedList<Integer> curr, int start) {
        result.add(new ArrayList<Integer>(curr));
        for (int i = start; i < nums.length; ++ i) {
            curr.add(nums[i]);
            backtracking(nums, result, curr, i + 1);
            curr.removeLast();
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i ++;
            }
        }
    }
}
