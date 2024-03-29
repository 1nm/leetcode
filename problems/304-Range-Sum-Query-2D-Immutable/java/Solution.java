public class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++ i) {
            for (int j = 0; j < matrix[0].length; ++ j) {
                if (i == 0 && j == 0) {
                    sum[0][0] = matrix[0][0];
                } else if (i == 0 && j > 0) {
                    sum[0][j] = matrix[0][j] + sum[0][j - 1];
                } else if (i > 0 && j == 0) {
                    sum[i][0] = matrix[i][0] + sum[i - 1][j];
                } else {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = (row1 == 0) ? 0 : sum[row1 - 1][col2];
        int left = (col1 == 0) ? 0 : sum[row2][col1 - 1];
        int upleft = (row1 == 0 || col1 == 0) ? 0 : sum[row1 - 1][col1 - 1];
        return sum[row2][col2] - up - left + upleft;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
