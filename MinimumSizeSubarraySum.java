public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, min = Integer.MAX_VALUE, sum = 0;
        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end++];
            }
            while (start < end && sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }
        return min <= nums.length ? min : 0;
    }
}