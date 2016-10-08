public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = (nums.length - 2) >> 1;
        for (int i = start; i >= 0; --i) {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= nums.length - k; --i) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums[nums.length - k];
    }
    
    private void heapify(int[] array, int size, int index) {
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;
        int mi = index;
        // make sure parent is larger than children
        if (left < size && array[mi] < array[left]) {
            mi = left;
        }
        if (right < size && array[mi] < array[right]) {
            mi = right;
        }
        if (mi != index) {
            // swap and recursively heapify
            int temp = array[index];
            array[index] = array[mi];
            array[mi] = temp;
            heapify(array, size, mi);
        }
    }
}