import java.util.PriorityQueue;

public class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<int[]> q =
        new PriorityQueue<>(10, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])); // a[0] is
                                                                                       // sum, a[1]
                                                                                       // is index
    for (int i = 0; i < mat.length; i++) {
      int sum = 0;
      for (int j = 0; j < mat[i].length; j++) {
        sum += mat[i][j];
      }
      q.add(new int[] {sum, i});
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = q.poll()[1];
    }
    return res;
  }
}
