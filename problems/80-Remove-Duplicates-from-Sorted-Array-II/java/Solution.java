public class Solution {
    public int removeDuplicates(int[] nums) {
        int total = 0;
        int i = 0;
        while (i < nums.length) {
            int curr = nums[i];
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j ++;
            }
            int l = j - i >= 2 ? 2 : 1;
            for (int k = total; k < total + l; ++ k) {
                nums[k] = curr;
            }
            total += l;
            i = j;
        }
        return total;
    }
}