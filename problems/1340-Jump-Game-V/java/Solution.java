import java.util.ArrayList;
import java.util.Collections;

public class Solution {
  private boolean canJump(int[] arr, int from, int to) {
    if (to < 0 || to >= arr.length || to == from) {
      return false;
    }
    if (arr[to] >= arr[from]) {
      return false;
    }
    if (to < from) {
      for (int i = to + 1; i < from; i++) {
        if (arr[i] >= arr[from]) {
          return false;
        }
      }
    } else {
      for (int i = from + 1; i < to; i++) {
        if (arr[i] >= arr[from]) {
          return false;
        }
      }
    }
    return true;
  }

  public int maxJumps(int[] arr, int d) {
    int len = arr.length;
    // dp[i] is the max jump starting from i
    ArrayList<Integer> indice = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      indice.add(i);
    }
    Collections.sort(indice, (a, b) -> arr[a] - arr[b]);
    int[] dp = new int[len];
    // Populate dp starting from the lowest index
    for (int i = 0; i < len; i++) {
      int from = indice.get(i);
      for (int to = from - d; to <= from + d; to++) {
        // For any possible jump to index, update dp[from] to get the max jump
        if (canJump(arr, from, to) && dp[from] < dp[to] + 1) {
          dp[from] = dp[to] + 1;
        }
      }
    }
    // Find the max jump from all starting indice
    int max = 0;
    for (int i = 0; i < len; i++) {
      if (max < dp[i]) {
        max = dp[i];
      }
    }
    return max + 1;
  }
}
