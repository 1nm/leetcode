public class Solution {
    public void wiggleSort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        int[] temp = new int[nums.length];
        int small = (nums.length - 1) / 2;
        int large = nums.length - 1;
        for (int i = 0; i < nums.length; i ++) {
            if (i % 2 == 0) {
                temp[i] = nums[small--];
            } else {
                temp[i] = nums[large--];
            }
        }
        for (int i = 0; i < nums.length; ++ i) {
            nums[i] = temp[i];
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
        for (int i = low; i < high; ++ i) {
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
