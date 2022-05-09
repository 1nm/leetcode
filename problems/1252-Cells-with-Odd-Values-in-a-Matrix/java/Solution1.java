class Solution1 {
  public int oddCells(int m, int n, int[][] indices) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    for (int[] index : indices) {
      int r = index[0];
      int c = index[1];
      if (rows.contains(r)) {
        rows.remove(r);
      } else {
        rows.add(r);
      }

      if (cols.contains(c)) {
        cols.remove(c);
      } else {
        cols.add(c);
      }
    }
    int count = 0;
    count += rows.size() * n;
    count += cols.size() * (m - rows.size());
    count -= cols.size() * rows.size();
    return count;
  }
}
