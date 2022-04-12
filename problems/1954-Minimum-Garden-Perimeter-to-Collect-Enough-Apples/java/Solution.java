public class Solution {
  private long f(int r) {
    // r is the half length of the edge
    return 2L * r * (r + 1) * (2 * r + 1);
  }

  public long minimumPerimeter(long neededApples) {
    int i = 0, j = (int) Math.pow(neededApples, 1.0 / 3.0);
    while (i < j) {
      int mid = (i + j) / 2;
      if (f(mid) < neededApples) {
        i = mid + 1;
      } else {
        j = mid;
      }
    }
    return i * 8;
  }
}
