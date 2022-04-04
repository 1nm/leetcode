import java.util.Stack;

public class Solution {
  public int minOperations(String[] logs) {
    Stack<String> stack = new Stack<>();
    for (String log : logs) {
      if (log.equals("../")) {
        if (!stack.empty()) {
          stack.pop();
        }
      } else if (log.equals("./")) {
        // do nothing
      } else {
        stack.push(log);
      }
    }
    return stack.size();
  }
}
