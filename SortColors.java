public class Solution {
    public void sortColors(int[] nums) {
        int rindex = 0, bindex = nums.length - 1;
        int i = 0;
        while (i <= bindex) {
            if (nums[i] == 0) {
                // swap i and rindex
                nums[i] = nums[rindex];
                nums[rindex++] = 0;
                i++;
            } else if (nums[i] == 2) {
                // swap i and bindex
                nums[i] = nums[bindex];
                nums[bindex--] = 2;
            } else {
                i++;
            }
        }
    }
}