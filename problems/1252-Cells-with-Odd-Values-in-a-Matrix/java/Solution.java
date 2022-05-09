class Solution {
  public int oddCells(int m, int n, int[][] indices) {
    // brute force
    int[][] matrix = new int[m][n];
    for (int[] index : indices) {
      int r = index[0];
      int c = index[1];
      for (int col = 0; col < n; col++) {
        matrix[r][col] += 1;
      }
      for (int row = 0; row < m; row++) {
        matrix[row][c] += 1;
      }
    }
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] % 2 == 1) {
          count += 1;
        }
      }
    }
    return count;
  }
}
