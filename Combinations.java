public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        process(result, new LinkedList<Integer>(), n, k, 1);
        return result;
    }

    private void process(List<List<Integer>> result, LinkedList<Integer> current, int n, int k, int i) {
        if (current.size() == k) {
            result.add(new ArrayList(current));
            return;
        }
        for (;i <= n; ++ i) {
            current.add(i);
            process(result, current, n, k, i + 1);
            current.removeLast();
        }
    }
}
