public class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    
    private int findMin(int[] nums, int begin, int end) {
        if (begin == end || begin + 1 ==  end) {
            return Math.min(nums[begin], nums[end]);
        }
        if (nums[end] >= nums[begin]) { // sorted
            return nums[begin];
        }
        int mid = (begin + end) / 2;
        if (nums[mid] >= nums[begin]) {
            return findMin(nums, mid, end);
        } else {
            return findMin(nums, begin, mid);
        }
    }
}