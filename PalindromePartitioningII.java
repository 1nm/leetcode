public class Solution {
    public int minCut(String s) {
        boolean[][] p = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); ++ j)
            for (int i = 0; i <= j; ++ i) {
                p[i][j] = (j - i < 3 || p[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
            }
        if (p[0][s.length() - 1]) return 0;
        int[] cuts = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); ++ i)
            cuts[i] = s.length() - i - 1;
        for (int i = s.length() - 1; i >= 0; -- i)
            for (int j = i; j < s.length(); ++ j)
                if (p[i][j]) cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
        return cuts[0];
    }
}
