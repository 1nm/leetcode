public class SolutionRecursion extends VersionControl {
  public int find(int start, int end) {
    int mid = end - (end - start) / 2;
    boolean isBad = isBadVersion(mid);
    if (isBad && (mid == 1 || !isBadVersion(mid - 1)))
      return mid;
    if (isBad)
      return find(start, mid - 1);
    else
      return find(mid + 1, end);
  }

  public int firstBadVersion(int n) {
    return find(1, n);
  }
}

