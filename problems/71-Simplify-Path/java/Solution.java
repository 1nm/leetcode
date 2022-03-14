public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] splitted = path.split("/");
        for (int i = 0; i < splitted.length; ++ i) {
            if (splitted[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (splitted[i].length() > 0 && !splitted[i].equals(".")) {
                stack.push(splitted[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
