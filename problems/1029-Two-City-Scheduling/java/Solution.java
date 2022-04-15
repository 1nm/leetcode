public class Solution {
  public int twoCitySchedCost(int[][] costs) {
      List<Integer> diff = new ArrayList<>();
      int sum = 0;
      for (int i = 0; i < costs.length; i ++) {
          sum += costs[i][0]; // calculate the sum if we send all people to city A
          diff.add(costs[i][0] - costs[i][1]); // cost we can reduce if we send people i to city B, higher the better
      }
      Collections.sort(diff, Collections.reverseOrder()); // sort the diff cost
      for (int i = 0; i < costs.length / 2; i ++) {
          sum -= diff.get(i); // send the first half people to city B and reduce the cost
      }
      return sum;
  }
}