public class Solution {
    public int reverse(int x) {
        // special cases: leading zeros, overflow
        boolean neg = x < 0;
        x = neg ? -x : x;
        long reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        reversed = neg ? -reversed : reversed;
        if (reversed >= (long) Integer.MIN_VALUE && reversed <= (long) Integer.MAX_VALUE) {
            return (int) reversed;
        }
        return 0;
    }
}
