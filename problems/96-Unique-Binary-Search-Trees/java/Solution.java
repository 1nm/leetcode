public class Solution {
    public int numTrees(int n) {
        /* DP
         * c[i] stands for the number of unique BSTs with i nodes
         * c[0] = c[1] = 1
         * c[n] = c[0] * c[n-1] // root = 1, left sub tree has 0 node, right sub tree has n-1 nodes
         * + c[1] * c[n - 2] // root = 2, left sub tree has 1 node, right sub tree has n-2 nodes
         * + c[2] * c[n - 3]
         * + ...
         * + c[n - 1] * c[0]
         */
        int[] c = new int[n + 1];
        c[0] = 1;
        c[1] = 1;
        for (int i = 2; i <= n; ++ i) {
            for (int j = 0; j < i; ++ j) {
                c[i] += c[j] * c[i - 1 - j];
            }
        }
        return c[n];
    }
}
