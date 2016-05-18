public class Solution {
    int[][] d = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[][] cache = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < m; ++ j) {
                max = Math.max(max, dfs(i, j, matrix, cache));
            }
        }
        return max;
    }

    int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        int length = 0;
        for (int dir = 0; dir < 4; ++ dir) {
            int ii = i + d[dir][0];
            int jj = j + d[dir][1];
            if (ii >= 0 && ii < matrix.length && jj >= 0 && jj < matrix[0].length && matrix[ii][jj] > matrix[i][j]) {
                length = Math.max(length, dfs(ii, jj, matrix, cache));
            }
        }
        cache[i][j] = length + 1;
        return cache[i][j];
    }
}
