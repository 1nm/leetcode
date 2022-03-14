public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] row = new HashSet[9];
        Set[] col = new HashSet[9];
        Set[] block = new HashSet[9];
        for (int i = 0; i < 9; ++ i) {
            for (int j = 0; j < 9; ++ j) {
                if (board[i][j] != '.') {
                    Integer num = new Integer(board[i][j] - '0');
                    if (row[i] == null) {
                        row[i] = new HashSet<Integer>(9);
                    }
                    if (col[j] == null) {
                        col[j] = new HashSet<Integer>(9);
                    }
                    if (block[i / 3 * 3 + j / 3] == null) {
                        block[i / 3 * 3 + j / 3] = new HashSet<Integer>(9);
                    }
                    if (row[i].contains(num) || col[j].contains(num) || block[i / 3 * 3 + j / 3].contains(num)) {
                        return false;
                    }
                    row[i].add(num);
                    col[j].add(num);
                    block[i / 3 * 3 + j / 3].add(num);
                }
            }
        }
        return true;
    }
}