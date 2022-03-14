public class Solution {
    public int numDistinct(String s, String t) {
        int tlen = t.length(), slen = s.length();
        if (tlen == 0) return 1;
        if (slen == 0) return 0;

        // dp[i][j] stands for the number of distinct subsequences of t.substring(0, i) in s.substring(0, j)
        // dp[0][j] = 1 as empty string is the subsequence of any string
        // dp[i][j - 1] don't take s[i - 2]
        // dp[i][j - 1] take s[i - 2]
        int[][] dp = new int[tlen + 1][slen + 1];
        for (int j = 0; j <= slen; ++ j)
            dp[0][j] = 1;
        for (int i = 1; i <= tlen; ++ i)
            for (int j = i; j <= slen; ++ j) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        return dp[tlen][slen];
    }
}
