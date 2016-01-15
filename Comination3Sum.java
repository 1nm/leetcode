public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        process(result, new LinkedList<Integer>(), k, n, 1);
    }

    private void process(List<List<Integer>> result, LinkedList<Integer> current, int k, int target, int i) {
        if (current.size() == k && target == 0) {
            result.add(new ArrayList(current));
            return;
        }
        for (; i <= 9; ++ i) {
            if (target - i >= 0) {
                current.add(i);
                process(result, current, k, target - i, i + 1);
                current.removeLast();
            }
        }
    }
}
