public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 1;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHP = new int[m][n];
        for (int i = m - 1; i >= 0; -- i) {
            for (int j = n - 1; j >= 0; -- j) {
                if (i == m - 1 && j == n - 1) {
                    minHP[i][j] = dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
                } else if (i == m - 1) {
                    minHP[i][j] = minHP[i][j + 1] - dungeon[i][j] <= 0 ? 1 : minHP[i][j + 1] - dungeon[i][j];
                } else if (j == n - 1) {
                    minHP[i][j] = minHP[i + 1][j] - dungeon[i][j]  <= 0 ? 1 : minHP[i + 1][j] - dungeon[i][j];
                } else {
                    minHP[i][j] = Math.min(minHP[i][j + 1] - dungeon[i][j] <= 0 ? 1 : minHP[i][j + 1] - dungeon[i][j], minHP[i + 1][j] - dungeon[i][j]  <= 0 ? 1 : minHP[i + 1][j] - dungeon[i][j]);
                }
            }
        }
        return minHP[0][0];
    }
}