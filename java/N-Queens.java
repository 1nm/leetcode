public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<List<String>>();
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        place(board, result, 0, n);
        return result;
    }
    
    private void place(char[][] board, List<List<String>> result, int row, int n) {
        if (row == n) { // found one solution
            List<String> solution = new ArrayList<String>();
            for (int i = 0; i < n; ++ i) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
        } else { // place queen on row
            for (int i = 0; i < n; ++ i) {
                if (isSafe(board, row, i)) {
                    board[row][i] = 'Q';
                    place(board, result, row + 1, n);
                    board[row][i] = '.';
                }
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col) {
        int i,j;
        i = row - 1;
        while (i >= 0) {
            if (board[i][col] == 'Q') {
                return false;
            }
            i --;
        }
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i --;
            j --;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board[0].length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i --;
            j ++;
        }
        return true;
    }
}