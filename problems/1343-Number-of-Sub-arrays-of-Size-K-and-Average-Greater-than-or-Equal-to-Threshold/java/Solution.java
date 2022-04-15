public class Solution {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
      int sum = 0;
      int count = 0;
      int i = 0;
      // calculate the sum of the sliding window
      while (i < k) {
          sum += arr[i];
          i ++;
      }
      if ((double) sum / k >= threshold) count += 1;

      while (i < arr.length) {
          sum += arr[i] - arr[i - k];
          if ((double) sum / k >= threshold) count += 1;
          i ++;
      }
      return count;
  }
}