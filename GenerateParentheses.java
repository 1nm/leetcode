public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<String>();
        process(parenthesis, "", 0, 0, n);
        return parenthesis;
    }

    // try adding ith parenthesis
    private void process(List<String> parenthesis, String current, int left, int right, int target) {
        if (left == target) {
            for (int i = 0; i < left - right; ++ i) {
                current += ")";
            }
            parenthesis.add(current);
        } else if (left > right) {
            process(parenthesis, current + "(", left + 1, right, target);
            process(parenthesis, current + ")", left, right + 1, target);
        } else if (left == right) {
            process(parenthesis, current + "(", left + 1, right, target);
        }
    }
}
