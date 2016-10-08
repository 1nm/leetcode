public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((int[] o1, int[] o2) -> o1[0] - o2[0]);
        heap.offer(new int[] {matrix[0][0], 0, 0});
        int[] c = null;
        while (k -- > 0) {
            c = heap.poll();
            int i = c[1], j = c[2];
            if (i + 1 < n)
                heap.offer(new int[] {matrix[i + 1][j], i + 1, j});
            if (i == 0 && j + 1 < m)
                heap.offer(new int[] {matrix[i][j + 1], i, j + 1});
        }
        return c[0];
    }
}