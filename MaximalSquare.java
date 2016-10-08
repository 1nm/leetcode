public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < m; ++ j) {
                dp[i][j] = matrix[i][j] - '0';
                if (i > 0 && j > 0 && dp[i][j] > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < m; ++ j) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}