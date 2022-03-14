public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(candidates, 0, 0, target, new LinkedList<Integer>(), result);
        return result;
    }
    
    private void backtracking(int[] candidates, int start, int sum, int target, LinkedList<Integer> curr, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList(curr));
            return;
        }
        for (int i = start; i < candidates.length; ++ i) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] <= target) {
                curr.add(candidates[i]);
                backtracking(candidates, i + 1, sum + candidates[i], target, curr, result);
                curr.removeLast();
            }
        }
    }
}