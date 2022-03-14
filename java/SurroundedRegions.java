public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        Queue<Pos> q = new LinkedList<Pos>();
        Set<Pos> region = new HashSet<Pos>();
        
        for (int i = 1; i < rows - 1; ++ i) {
            for (int j = 1; j < cols - 1; ++ j) {
                if (visited[i][j]) {
                    continue;
                }
                boolean dead = true;
                q.clear();
                region.clear();
                visited[i][j] = true;
                if (board[i][j] == 'O') {
                    q.add(new Pos(i,j));
                    while (!q.isEmpty()) {
                        Pos pos = q.poll();
                        region.add(pos);
                        for (int k = 0; k < 4; ++ k) {
                            int newRow = pos.row + drow[k];
                            int newCol = pos.col + dcol[k];
                            if (!visited[newRow][newCol] && board[newRow][newCol] == 'O') {
                                if (newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1) {
                                    dead = false;
                                    continue;
                                }
                                visited[newRow][newCol] = true;
                                q.add(new Pos(newRow, newCol));
                            }
                        }
                    }
                    if (dead) {
                        for (Pos pos : region) {
                            board[pos.row][pos.col] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    class Pos {
        int row;
        int col;
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}