public class Solution {
    public int minPatches(int[] nums, int n) {
        if (n <= 0) return 0;
        if (nums == null) nums = new int[0];
        int count = 0, i = 0;
        long nextMissing = 1;
        while (nextMissing <= (long) n) {
            if (i < nums.length && nums[i] <= nextMissing) {
                nextMissing += nums[i++];
            } else {
                nextMissing += nextMissing;
                count++;
            }
        }
        return count;
    }
}
