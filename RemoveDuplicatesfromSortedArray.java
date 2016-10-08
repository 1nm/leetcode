public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; ++ i) {
            nums[len++] = nums[i];
            while (i < nums.length - 1 && nums[i + 1] == nums[i])
                i++;
        }
        return len;
    }
}