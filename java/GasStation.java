public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        int totalDiff = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; ++ i) {
            diff[i] = gas[i] - cost[i];
            totalDiff += diff[i];
            sum += diff[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return totalDiff < 0 ? -1 : start;
    }
}