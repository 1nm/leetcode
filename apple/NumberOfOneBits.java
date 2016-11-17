public class Solution {
    // you need to treat n as an unsigned value
    // use unsigned shift for bit manipulation
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}
