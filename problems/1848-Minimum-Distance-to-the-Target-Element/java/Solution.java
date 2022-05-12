class Solution {
  public int getMinDistance(int[] nums, int target, int start) {
    int p = start, q = start;
    while (p >= 0 || q < nums.length) {
      if (p >= 0 && nums[p] == target)
        return Math.abs(p - start);
      if (q < nums.length && nums[q] == target)
        return Math.abs(q - start);
      p--;
      q++;
    }
    // Should not be reached
    return -1;
  }
}
