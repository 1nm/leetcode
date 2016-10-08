public class Solution {
    public void rotate(int[] nums, int k) {
        int pivot = nums.length - k % nums.length;
        reverse(nums, 0, pivot);
        reverse(nums, pivot, nums.length);
        reverse(nums, 0, nums.length);
    }
    
    public void reverse(int[] nums, int begin, int end) {
        int temp;
        int i = begin;
        int j = end - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }
}