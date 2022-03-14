public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int partition = nums.length - 2; // find partition number from right (first number that is less than its right)
        while (partition >= 0) {
            if (nums[partition] < nums[partition + 1]) {
                break;
            }
            partition --;
        }
        int start;
        if (partition != -1) { // find change number (first number that is greater than partition number)
            int change = nums.length - 1;
            while (change > 0) {
                if (nums[change] > nums[partition]) {
                    break;
                }
                change --;
            }
            int temp = nums[partition]; // swap partition and change, reverse all number on partition's right
            nums[partition] = nums[change];
            nums[change] = temp;
            start = partition + 1;
        } else {
            start = 0; // can't find partition, reverse all numbers
        }
        // reverse all elements from start to end
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}