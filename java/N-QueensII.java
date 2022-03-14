public class Solution {
    int size;
    boolean[][] board;
    int total = 0;
    
    public int totalNQueens(int n) {
        size = n;
        board = new boolean[size][];
        for (int i = 0; i < size; ++ i) {
            board[i] = new boolean[size];
        }
        place(0);
        return total;
    }
    
    private boolean ok(int row, int col) {
        // check previous rows
        int i = row - 1;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i --;
        }
        
        // check upper left diagonal
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i --;
            j --;
        }
        
        // check upper right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < size) {
            if (board[i][j]) {
                return false;
            }
            i --;
            j ++;
        }
        
        return true;
    }
    
    // try ith queen
    private void place(int i) {
        for (int j = 0; j < size; ++ j) {
            if (ok(i, j)) {
                board[i][j] = true;
                if (i == size - 1) {
                    total++;
                } else {
                    place(i + 1);
                }
                board[i][j] = false;
            }
        }
    }
}