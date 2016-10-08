public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; ++ i) {
            int mask = 1 << i;
            for (int j = 0; j < nums.length; ++ j) {
                bits[i] += (nums[j] & mask) == 0 ? 0 : 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; ++ i) {
            result += (bits[i] % 3) == 0 ? 0 : (1 << i);
        }
        return result;
    }
}