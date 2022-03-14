public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            long num = numbers[lo] + numbers[hi];
            if (num == target) {
                return new int[] {lo + 1, hi + 1};
            } else if (num < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return null; // should not reach here
    }
}