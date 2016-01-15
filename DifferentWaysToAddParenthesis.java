public class Solution {

    private int compute (int n1, int n2, char operator) {
        int result = 0;
        switch(operator) {
        case '+': result = n1 + n2;break;
        case '-': result = n1 - n2;break;
        case '*': result = n1 * n2;break;
        }
        return result;
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        int num = 0;
        boolean onlyNumber = true;
        for (int i = 0; i < input.length(); ++ i) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                onlyNumber = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int n1 : left) {
                    for (int n2 : right) {
                        result.add(compute(n1, n2, c));
                    }
                }
            } else {
                num = num * 10 + (c - '0');
            }
        }
        if (onlyNumber) {
            result.add(num);
        }
        return result;
    }
}
