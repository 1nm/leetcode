public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return binarySearch(nums, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int begin, int end) {
        int mid = (begin + end) / 2;
        int left = mid - 1;
        int right = mid + 1;
        
        int lnum = left < 0 ? Integer.MIN_VALUE : nums[left];
        boolean leftmost = left < 0;
        int rnum = right > nums.length - 1 ? Integer.MIN_VALUE : nums[right];
        boolean rightmost = right > nums.length - 1;

        if ((leftmost || lnum < nums[mid]) && (rightmost || rnum < nums[mid])) { // found peak
            return mid;
        } else if ((leftmost || lnum < nums[mid]) && rnum > nums[mid]) { // right is bigger
            return binarySearch(nums, right, end);
        } else if (lnum > nums[mid] && (rightmost || rnum < nums[mid])) { // left is bigger
            return binarySearch(nums, begin, left);
        } else { // valley
            return binarySearch(nums, begin, left);
        }
    }
}