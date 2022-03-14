public class Solution {
    public String largestNumber(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++ i) {
            sb.append(nums[i]);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
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
        int pivot = nums[high];
        int i = low; // swap index;
        for (int j = low; j < high; j ++) {
            if (compareTo(nums[j], pivot) > 0) { // swap j to i
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
        }
        nums[high] = nums[i];
        nums[i] = pivot;
        return i;
    }
    
    int compareTo(int a, int b) {
        String stra = String.valueOf(a);
        String strb = String.valueOf(b);
        StringBuilder ab = new StringBuilder(stra);
        StringBuilder ba = new StringBuilder(strb);
        ab.append(strb);
        ba.append(stra);
        for (int i = 0; i < ab.length(); ++ i) {
            int diff = ab.charAt(i) - ba.charAt(i);
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }
}