
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = newNums[n + 1] = 1;

        int[][] max = new int[n + 2][n + 2];

        for (int j = 2; j < n + 2; ++ j) {
            for (int i = 0; i + j < n + 2; ++ i) {
                for (int k = i + 1; k < i + j; ++ k) {
                    max[i][i + j] = Math.max(max[i][i + j], newNums[i]* newNums[k] * newNums[i + j] + max[i][k] + max[k][i + j]);
                }
            }
        }
        return max[0][n + 1];
    }
}
