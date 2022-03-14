public class Solution {
    // private static final String patternRegex = "(?<num>\\d+)|(?<op>[+-\\\\*/])";

    public int calculate(String s) {
        Stack<Character> ops = new Stack<Character>();
        Stack<Integer> nums = new Stack<Integer>();
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch(c) {
            case ' ': break;
            case '+':
            case '-': {
                while (!ops.isEmpty()) {
                    calc(ops, nums);
                }
                ops.push(c);
                break;
            }
            case '*':
            case '/': {
                while (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    calc(ops, nums);
                }
                ops.push(c);
                break;
            }
            default: {
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    buffer.append(s.charAt(i++));
                }
                int num = Integer.parseInt(buffer.toString());
                nums.push(num);
                buffer.setLength(0);
                continue;
            }
            }
            i ++;
        }
        while (!ops.isEmpty()) {
            calc(ops, nums);
        }
        return nums.peek();
    }

    private void calc(Stack<Character> ops, Stack<Integer> nums) {
        int num2 = nums.pop();
        int num1 = nums.pop();
        char op = ops.pop();
        switch (op) {
        case '+': nums.push(num1 + num2); break;
        case '-': nums.push(num1 - num2); break;
        case '*': nums.push(num1 * num2); break;
        case '/': nums.push(num1 / num2); break;
        }
    }
}