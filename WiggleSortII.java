public class Solution {
    public void wiggleSort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        for (int i = 1; i < nums.length / 2; i += 2) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i];
            nums[nums.length - i] = temp;
        }
    }

    void quicksort(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (low < high) {
            int p = partition(nums, low, high);
            quicksort(nums, low, p - 1);
            quicksort(nums, p + 1, high);
        }
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[high], pos = low;
        for (int i = low, i < high; ++ i) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos++] = temp;
            }
        }
        nums[high] = nums[pos];
        nums[pos] = pivot;
        return pos;
    }
}
