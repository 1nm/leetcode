public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> numbers = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return numbers;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        int vsteps = m - 1;
        int hsteps = n - 1;
        for (int i = 0; i < n; ++ i) {
            numbers.add(matrix[0][i]);
        }
        int i = 0, j = n - 1, dir = 1;
        while (vsteps > 0 || hsteps > 0) {
            int steps = (dir % 2 == 1) ? vsteps-- : hsteps--;
            if (steps == 0) {
                break;
            }
            for (int k = 0; k < steps; ++ k) {
                i += di[dir];
                j += dj[dir];
                numbers.add(matrix[i][j]);
            }
            dir = (dir + 1) % 4;
        }
        return numbers;
    }
}
