class Solution {
  public int countGoodRectangles(int[][] rectangles) {
    Map<Integer, Integer> count = new HashMap<>();
    int maxLen = 0;
    for (int[] rect : rectangles) {
      int len = Math.min(rect[0], rect[1]);
      count.put(len, count.getOrDefault(len, 0) + 1);
      maxLen = Math.max(maxLen, len);
    }
    return count.get(maxLen);
  }
}
