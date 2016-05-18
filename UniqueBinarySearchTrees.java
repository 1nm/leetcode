public class Solution {
    public int numTrees(int n) {
        /* DP
         * c[i] stands for the number of unique BSTs with i+1 nodes
         * c[n] = c[0] * c[n-1] // root is 1, number of left sub tree is
         * + c[1] * c[n - 2] // root is 2, 
         * + c[2] * c[n - 3]
         * + ...
         * + c[n - 1] * c[0]
         */
            int[] c = new int[n];
        c[0] = 1;
        for (int i = 1; i < n; ++ i) {
            for (int j = 0; j < n; ++ j) {
                c[i] += c[j] * c[n - 1 - j];
            }
        }
        return c[n];
    }
}
