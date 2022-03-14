public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = searchLowerBound(nums, target);
        if (lower == -1) {
            return new int[] {-1, -1};
        }
        int upper = searchUpperBound(nums, target);
        return new int[] {lower, upper};
    }

    private int searchLowerBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start] == target ? start : -1;
    }

    private int searchUpperBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + ((end - start + 1) >> 1);
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return nums[start] == target ? start : -1;
    }
}