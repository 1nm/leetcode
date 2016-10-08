public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // xor = a ^ b
        for (int i = 0; i < nums.length; ++ i) {
            xor ^= nums[i];
        }
        
        // find first bit that is different
        int k = 1;
        for (int i = 0; i < 32; ++ i) {
            k = 1 << i;
            if ((xor & k) != 0) {
                break;
            }
        }
        
        // split numbers into two groups and repeat the xor method to get the two numbers separately
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++ i) {
            if ((nums[i] & k) != 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[] {a, b};
    }
}