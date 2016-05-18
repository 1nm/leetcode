public class Solution {
    public int findDuplicate(int[] nums) {
        // binary search and pigeonhole principle
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // avoid overflow
            int count = 0;
            for (int i = 0; i < nums.length; ++ i) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
