public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] counter = new int[26];
        boolean[] inStack = new boolean[26];
        for (int i = 0; i < s.length(); ++ i) {
            counter[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); ++ i) {
            int index = s.charAt(i) - 'a';
            counter[index] --;
            if (!inStack[index]) {
                while(!stack.isEmpty() && stack.peek() > s.charAt(i) && counter[stack.peek() - 'a'] > 0) {
                    inStack[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(s.charAt(i));
                inStack[index] = true;
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}