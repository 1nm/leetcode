public class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] lines = input.split("\n");
        int currLevel = 0, currLen = 0, maxLen = 0;
        stack.push(0);
        for (int i = 0; i < lines.length; ++ i) {
            int level = lines[i].lastIndexOf('\t') + 1;
            int len = level > 1 ? lines[i].length() - level + 1 : lines[i].length();
            while (stack.size() > level + 1) {
                stack.pop();
            }
            currLen = stack.peek();
            if (isFilename(lines[i]) && currLen + len > maxLen) {
                maxLen = currLen + len;
            }
            stack.push(currLen + len);
        }
        return maxLen;
    }
    
    private boolean isFilename(String str) {
        return str.contains(".") && str.charAt(str.length() - 1) != '.' && str.charAt(0) != '.';
    }
}