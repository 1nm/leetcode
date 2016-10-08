public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(nums, result, new LinkedList<Integer>(), 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, LinkedList<Integer> curr, int i) {
        result.add(new ArrayList<Integer>(curr));
        while (i < nums.length) {
            curr.add(nums[i]);
            backtracking(nums, result, curr, i + 1);
            curr.removeLast();
            i ++;
        }
    }
}
