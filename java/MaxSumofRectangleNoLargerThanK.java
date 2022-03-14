public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int limit) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        boolean transpose = (matrix.length > matrix[0].length);
        int n = transpose ? matrix[0].length : matrix.length, m = transpose ? matrix.length : matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++ i) {
            int[] array = new int[m];
            for (int j = i; j >= 0; -- j) {
                int sum = 0;
                for (int k = 0; k < m; ++ k)
                    array[k] += transpose ? matrix[k][j] : matrix[j][k];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int k = 0; k < m; ++ k) {
                    sum += array[k];
                    Integer ceil = set.ceiling(sum - limit);
                    if (ceil != null) {
                        max = Math.max(max, sum - ceil.intValue());
                    }
                    set.add(sum);
                }
            }
        }
        return max;
    }
}