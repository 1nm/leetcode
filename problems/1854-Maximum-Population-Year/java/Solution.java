class Solution {
  public int maximumPopulation(int[][] logs) {
    int[] p = new int[2051];
    for (int[] log : logs) {
      p[log[0]] += 1;
      p[log[1]] -= 1;
    }
    int max = 0;
    int maxYear = 0;
    int sum = 0;
    for (int year = 1950; year <= 2050; year++) {
      sum += p[year];
      if (max < sum) {
        max = sum;
        maxYear = year;
      }
    }
    return maxYear;
  }
}
