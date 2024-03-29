public class Solution {
    List<Set<Integer>> used;
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        init();
        backtrack(0, 0);
    }

    void init() {
        used = new ArrayList<>();
        for (int i = 0; i < 27; ++ i)
            used.add(new HashSet<Integer>());
        for (int i = 0; i < 9; ++ i) {
            for (int j = 0; j < 9; ++ j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    add(i, j, num);
                }
            }
        }
    }

    void add(int i, int j, int num) {
        this.used.get(i).add(num);
        this.used.get(9 + j).add(num);
        this.used.get(18 + (i / 3) * 3 + (j / 3)).add(num);
    }

    void remove(int i, int j, int num) {
        this.used.get(i).remove(num);
        this.used.get(9 + j).remove(num);
        this.used.get(18 + (i / 3) * 3 + (j / 3)).remove(num);
    }

    Set<Integer> avail(int i, int j) {
        Set<Integer> ret = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ret.removeAll(used.get(i));
        ret.removeAll(used.get(9 + j));
        ret.removeAll(used.get(18 + (i / 3) * 3 + (j / 3)));
        return ret;
    }

    private boolean backtrack(int i, int j) {
        if (this.board[i][j] != '.') { // number
            if (i == 8 && j == 8) {
                return true;
            } else if (j < 8) {
                if (backtrack(i, j + 1)) return true;
            }
            else {
                if (backtrack(i + 1, 0)) return true;
            }
            return false;
        } else {
            Set<Integer> avail = avail(i, j);
            for (int num : avail) {
                add(i, j, num);
                board[i][j] = (char)(num + '0');
                if (i == 8 && j == 8) {
                    return true;
                } else if (j < 8) {
                    if (backtrack(i, j + 1)) return true;
                } else {
                    if (backtrack(i + 1, 0)) return true;
                }
                remove(i, j, num);
            }
            this.board[i][j] = '.';
            return false;
        }
    }

}