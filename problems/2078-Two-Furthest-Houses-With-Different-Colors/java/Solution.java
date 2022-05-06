public class Solution {
  public int maxDistance(int[] colors) {
    int len = colors.length;
    int i = 0;
    while (i < colors.length && colors[i] == colors[len - 1]) {
      i += 1;
    }
    int left = len - 1 - i;
    i = len - 1;
    while (i >= 0 && colors[i] == colors[0]) {
      i -= 1;
    }
    int right = i;
    return Math.max(left, right);
  }
}
