public class Solution {
    public boolean isPowerOfTwo(int n) {
        int p = 1;
        while (p < n) {
            if ((n & p) != 0) {
                return false;
            }
            p = p << 1;
        }
        return n == p;
    }
}