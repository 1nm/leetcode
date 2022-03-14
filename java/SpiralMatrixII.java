public class Solution {
    public int[][] generateMatrix(int n) {
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        int dir = 0;

        // initialization
        int[][] spiral = new int[n][];
        for (int i = 0; i < n; ++ i) {
            spiral[i] = new int[n];
        }

        int i = 0, j = 0, count = 1;
        while (count <= n * n) {
            spiral[i][j] = count++;
            int newi = i + di[dir];
            int newj = j + dj[dir];
            if (!(newi >=0 && newi < n && newj >= 0 && newj < n && spiral[newi][newj] == 0)) {
                dir = (dir + 1) % 4;
            }
            i += di[dir];
            j += dj[dir];
        }
        return spiral;
    }
}
