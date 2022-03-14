/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("["))
            return new NestedInteger(Integer.parseInt(s));
        NestedInteger root = null;
        NestedInteger curr = null;
        int num = 0;
        int sign = 1;
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            char pre = i == 0 ? ' ' : s.charAt(i - 1);
            switch (c) {
            case '[':
                if (curr != null)
                    stack.push(curr);
                curr = new NestedInteger();
                if (root == null)
                    root = curr;
                break;
            case ']':
                // finalize ni
                if (pre >= '0' && pre <= '9')
                    curr.add(new NestedInteger(num * sign));
                if (!stack.isEmpty()) {
                    stack.peek().add(curr);
                    curr = stack.pop();
                }
                num = 0;
                sign = 1;
                break;
            case '-':
                sign = -1;
                break;
            case ',':
                if (pre >= '0' && pre <= '9')
                    curr.add(new NestedInteger(num * sign));
                num = 0;
                sign = 1;
                break;
            default: // 0-9
                num = num * 10 + (int) (c - '0');
                break;
            }
        }
        return root;
    }
}