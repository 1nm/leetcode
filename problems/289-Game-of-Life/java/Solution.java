public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[] di = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dj = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                int count = 0;
                for (int dir = 0; dir < 8; ++ dir) {
                    int ni = i + di[dir];
                    int nj = j + dj[dir];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && (board[ni][nj] & 1) == 1) {
                        count ++;
                    }
                }
                if ((board[i][j] & 1) == 1 && (count == 2 || count == 3) || (board[i][j] & 1) == 0 && count == 3) {
                    board[i][j] |= (1 << 1);
                }
            }
        }
        
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                board[i][j] = (board[i][j] >> 1);
            }
        }
    }
}