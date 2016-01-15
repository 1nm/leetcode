public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        backtracking(candidates, target, 0, 0, new LinkedList<Integer>(), results);
        return results;
    }

    private void backtracking(int[] candidates, int target, int start, int sum, LinkedList<Integer> curr, List<List<Integer>> results) {
        if (sum == target) {
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i < candidates.length; ++ i) {
            if (sum + candidates[i] <= target) {
                curr.add(candidates[i]);
                backtracking(candidates, target, start, sum + candidates[i], curr, results);
                curr.removeLast();
            }
        }
    }
}
