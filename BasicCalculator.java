public class Solution {
    public int calculate(String s) {
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            switch (curr) {
                case ' ': break;
                case '+':
                case '-':
                case '(': operators.push(curr); break;
                case ')': {
                    operators.pop(); 
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        int b = operands.pop();
                        int a = operands.pop();
                        char op = operators.pop();
                        if (op == '+') {
                            operands.push(a + b);
                        } else if (op == '-') {
                            operands.push(a - b);
                        }
                    }
                    break;
                }
                default: {
                    int j = 1;
                    while (i + j < s.length() && s.charAt(i + j) >= '0' && s.charAt(i + j) <= '9') {
                        j ++;
                    }
                    int num = Integer.parseInt(s.substring(i, i + j));
                    if (operators.isEmpty() || operators.peek() == '(') {
                        operands.push(num);
                    } else {
                        int a = operands.pop();
                        char op = operators.pop();
                        if (op == '+') {
                            operands.push(a + num);
                        } else if (op == '-') {
                            operands.push(a - num);
                        }
                    }
                    i += j;
                    continue;
                }
            }
            i ++;
        }
        return operands.pop();
    }
}