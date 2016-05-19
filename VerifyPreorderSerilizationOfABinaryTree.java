public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack();
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            if ("#".equals(node)) {
                boolean removed = false;
                while (stack.size() > 1 && "#".equals(stack.peek())) {
                    stack.pop();
                    if ("#".equals(stack.peek())) return false;
                    stack.pop();
                    removed = true;
                }
                if (removed) {
                    stack.push("#");
                    continue;
                }
            }
            stack.push(node);
        }
        return (stack.size() == 1 && "#".equals(stack.peek()));
    }
}
