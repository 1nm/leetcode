public class Solution {
    public boolean isMatch(String s, String p) {
        return backtracking(s.toCharArray(), s.length() - 1, p.toCharArray(), p.length() - 1);
    }

    private boolean backtracking(char[] s, int i, char[] p, int j) {
        if (i == -1 && j == -1)
            return true;
        if (i != -1 && j == -1)
            return false;
        if (i == -1 && j != -1) {
            if (p[j] == '*')
                return backtracking(s, i, p, j - 1);
            else
                return false;
        }
        if (s[i] == p[j] || p[j] == '?') {
            return backtracking(s, i - 1, p, j - 1);
        } else if (p[j] == '*') {
            if (backtracking(s, i - 1, p, j))
                return true;
            if (backtracking(s, i, p, j - 1))
                return true;
        }
        return false;
    }
}
