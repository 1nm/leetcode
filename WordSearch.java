public class Solution {
    private static final int[] di = new int[] {-1, 0, 1, 0};
    private static final int[] dj = new int[] {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++ i) {
            for (int j = 0; j < board[i].length; ++ j) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int pos, String word) {
        if (pos == word.length() - 1 && !visited[i][j] && board[i][j] == word.charAt(pos)) {
            // found
            return true;
        }
        if (!visited[i][j] && board[i][j] == word.charAt(pos)) {
            visited[i][j] = true;
            for (int dir = 0; dir < 4; ++ dir) {
                int ii = i + di[dir];
                int jj = j + dj[dir];
                if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && !visited[ii][jj]) {
                    if (dfs(board, visited, ii, jj, pos + 1, word)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
