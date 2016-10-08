public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private int binarySearch(int[] nums, int begin, int end, int target) {
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            if (mid == begin) {
                return mid;
            } else {
                return binarySearch(nums, begin, mid - 1, target);
            }
        } else {
            if (mid == end) {
                return mid + 1;
            } else {
                return binarySearch(nums, mid + 1, end, target);
            }
        }
    }
}