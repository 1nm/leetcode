public class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < m; ++ j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands ++;
                    visit(grid, visited, i, j, n, m);
                }
            }
        }
        return islands;
    }
    
    private void visit(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        if (i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            visit(grid, visited, i, j + 1, n, m);
            visit(grid, visited, i + 1, j, n, m);
            visit(grid, visited, i - 1, j, n, m);
            visit(grid, visited, i, j - 1, n, m);
        }
    }
}