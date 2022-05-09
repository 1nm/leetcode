import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    // Greedy, keep track of maxProfit that maxProfit[i] is the maxmium profit that among the work
    // which difficulty are less than difficulty[i]
    // Sum the max profit for each worker
    int n = difficulty.length;
    List<List<Integer>> jobs = new ArrayList<>();
    for (int i = 0; i < difficulty.length; i++) {
      jobs.add(Arrays.asList(difficulty[i], profit[i]));
    }
    Collections.sort(jobs, (a, b) -> a.get(0) - b.get(0));
    Arrays.sort(worker);
    int maxProfit = 0;
    int sum = 0;
    int i = 0;
    for (int j = 0; j < worker.length; j++) {
      while (i < n && jobs.get(i).get(0) <= worker[j]) {
        maxProfit = Math.max(maxProfit, jobs.get(i).get(1));
        i++;
      }
      sum += maxProfit;
    }
    return sum;
  }
}
