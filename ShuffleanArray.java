public class Solution {

    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = Arrays.copyOf(nums, nums.length);
        for (int i = ret.length - 1; i >= 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = ret[i];
            ret[i] = ret[j];
            ret[j] = temp;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */