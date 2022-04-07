class Solution {
  private int[][] mem;

  public int superEggDrop(int k, int n) {
    mem = new int[k + 1][n + 1];
    return dp(k, n);
  }

  private int dp(int k, int n) {
    if (n == 0)
      return 0;
    if (k == 1)
      return n;
    if (mem[k][n] > 0)
      return mem[k][n];
    int min = Integer.MAX_VALUE;
    int i = 1, j = n;
    while (i <= j) {
      int mid = (i + j) / 2;
      int t1 = dp(k - 1, mid - 1);
      int t2 = dp(k, n - mid);
      int newValue = 1 + Math.max(t1, t2);
      min = Math.min(min, newValue);
      if (t1 < t2) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }
    mem[k][n] = min;
    return min;
  }
}
