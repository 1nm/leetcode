public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // for loop to check blocks needs attention
        int[] counter = new int[10];
        // check rows
        for (int i = 0; i < 9; ++ i) {
            Arrays.fill(counter, 0);
            for (int j = 0; j < 9; ++ j) {
                if (board[i][j] != '.') {
                    counter[board[i][j] - '0'] ++;
                }
            }
            if (!isValid(counter)) return false;
        }
        // check columns
        for (int i = 0; i < 9; ++ i) {
            Arrays.fill(counter, 0);
            for (int j = 0; j < 9; ++ j) {
                if (board[j][i] != '.') {
                    counter[board[j][i] - '0'] ++;
                }
            }
            if (!isValid(counter)) return false;
        }
        // check blocks
        for (int i = 0; i < 9; ++ i) {
            Arrays.fill(counter, 0);
            for (int j = 0; j < 9; ++ j) {
                char c = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
                if (c != '.') {
                    counter[c - '0'] ++;
                }
            }
            if (!isValid(counter)) return false;
        }
        return true;
    }

    private boolean isValid(int[] counter) {
        for (int i = 1; i < 10; ++ i)
            if (counter[i] > 1) return false;
        return true;
    }

}
