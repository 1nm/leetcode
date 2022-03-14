public class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int pos = 0;
        while (pos < nums.length && nums[pos] != target)
            pos++;
        if (pos == nums.length - 1) return pos;
        int count = 1, i = pos + 1;
        for (;i < nums.length; ++ i) {
            if (nums[i] == target) {
                count ++;
                if ((int) (Math.random() * count) == 0)
                    pos = i;
            }
        }
        return pos;
    }
}
