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
                    sum[0][j] = matrix[0][j];
                } else if (i > 0 && j == 0) {
                    sum[i][0] = matrix[i][0];
                } else {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - sum[row1][col2] - sum[row2][col1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix m = new NumMatrix(matrix);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
