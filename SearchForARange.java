public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchLowerBound(nums, target), searchUpperBound(nums, target)};
    }

    private int searchLowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2; // avoid overflow
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start] == target ? start : -1;
    }

    private int searchUpperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2; // avoid overflow
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[end] == target ? end : -1;
    }
}
