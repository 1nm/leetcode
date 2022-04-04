import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
  private int count = 0;

  private boolean isSquareSum(int a, int b) {
    int sum = a + b;
    int sqrt = (int) Math.sqrt((double) sum);
    return sqrt * sqrt == sum;
  }

  private void backtrack(int[] nums, Set<Integer> visited, LinkedList<Integer> current) {
    if (current.size() == nums.length) {
      count++;
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited.contains(i)
          || (i - 1 >= 0 && !visited.contains(i - 1) && nums[i] == nums[i - 1])) {
        // prune if nums[i] has been used, or nums[i - 1] == nums[i] but not yet used
        // this guarantees that the result list will not be the same
        continue;
      }
      if (current.isEmpty() || isSquareSum(current.getLast(), nums[i])) {
        visited.add(i);
        current.add(nums[i]);
        backtrack(nums, visited, current);
        current.removeLast();
        visited.remove(i);
      }
    }
  }

  public int numSquarefulPerms(int[] nums) {
    Set<Integer> visited = new HashSet<>();
    LinkedList<Integer> current = new LinkedList<>();
    Arrays.sort(nums);
    backtrack(nums, visited, current);
    return count;
  }
}
