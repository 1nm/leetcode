public class Solution {
    // you need treat n as an unsigned value
    // process bits with long type and convert to int
    
    public int reverseBits(int n) {
        long r = 0L;
        long nn = (long) n;
        for (int i = 0; i < 32; ++ i) {
            r |= (nn & (1L << i)) > 0 ? (1L << (31 - i)) : 0;
        }
        return (int) (r & 0xFFFFFFFF);
    }
}
