public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int len = numbers.length;
    // O (n log n)
    for (int i = 0; i < len; i++) {
      // binary search in [i + 1, len)
      int start = i + 1, end = len;
      int binarySearchTarget = target - numbers[i];
      while (start < end) {
        int mid = (start + end) / 2;
        if (numbers[mid] == binarySearchTarget) {
          return new int[] {i + 1, mid + 1};
        }
        if (numbers[mid] < binarySearchTarget) {
          start = mid + 1;
        } else {
          end = mid;
        }
      }
    }
    // shouldn't be reached as it is guaranteed that there is exactly one solution.
    return new int[] {0, 0};
  }
}
