public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        for (int i = 0; i < tokens.length; ++ i) {
            if (isOperator(tokens[i])) {
                int b = operands.pop();
                int a = operands.pop();
                operands.push(calculate(a, b, tokens[i].charAt(0)));
            } else {
                operands.push(Integer.parseInt(tokens[i]));
            }
        }
        return operands.pop();
    }
    
    private int calculate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}