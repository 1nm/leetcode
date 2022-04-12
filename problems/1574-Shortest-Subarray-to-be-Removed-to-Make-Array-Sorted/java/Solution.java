public class Solution {
  public int findLengthOfShortestSubarray(int[] arr) {
    int p = 0, q = arr.length - 1;
    // find the longest non-descreasing sub arrays from both side
    while (p + 1 < arr.length && arr[p + 1] >= arr[p]) {
      p++;
    }
    if (p == arr.length - 1)
      return 0;
    while (q - 1 >= 0 && arr[q - 1] <= arr[q]) {
      q--;
    }
    int i = 0, j = q;
    int res = Math.min(arr.length - p - 1, q);
    while (i <= p && j < arr.length) {
      if (arr[i] <= arr[j]) {
        res = Math.min(res, j - i - 1);
        i++;
      } else {
        j++;
      }
    }
    return res;
  }
}
