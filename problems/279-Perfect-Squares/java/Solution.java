public class Solution {
    public int numSquares(int n) {
        int[] min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; ++ i) {
            min[i * i] = 1;
        }
        for (int i = 1; i <= n; ++ i) {
            for (int j = 1; i * i + j <= n; ++ j) {
                min[i * i + j] = Math.min(min[i * i + j], min[j] + 1);
            }
        }
        return min[n];
    }
}
