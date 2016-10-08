public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            if (c == '(') left ++;
            if (c == ')')
                if (left == 0) right ++;
                else left --;
        }
        dfs(result, new StringBuilder(), s, 0, left, right, 0);
        return new ArrayList<String>(result);
    }

    void dfs(Set<String> result, StringBuilder sb, String s, int pos, int left, int right, int open) {
        if (pos == s.length() && left == 0 && right == 0 && open == 0) {
            result.add(sb.toString());
            return;
        }

        if (pos == s.length() || left < 0 || right < 0 || open < 0) return;

        char c = s.charAt(pos);
        int len = sb.length();

        if (c == '(') {
            dfs(result, sb, s, pos + 1, left - 1, right, open);
            dfs(result, sb.append(c), s, pos + 1, left, right, open + 1);
        } else if (c == ')') {
            dfs(result, sb, s, pos + 1, left, right - 1, open);
            dfs(result, sb.append(c), s, pos + 1, left, right, open - 1);
        } else {
            dfs(result, sb.append(c), s, pos + 1, left, right, open);
        }

        sb.setLength(len);
    }
}
