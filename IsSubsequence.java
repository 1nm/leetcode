public class Solution {
    public boolean isSubsequence(String s, String t) {
        return search(s, t, 0, 0);
    }

    public boolean search(String s, String t, int i, int j) {
        if (s.length() > t.length())
            return false;
        if (s.length() == 0)
            return true;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                if (i == s.length() - 1)
                    return true;
                else
                    i ++;
            }
            j ++;
        }
        return false;
    }
}
