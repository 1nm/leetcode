public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        int sign = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) ? 1 : -1;
        long a = dividend >= 0 ? dividend : - ((long) dividend);
        long b = divisor >= 0 ? divisor : - ((long) divisor);
        
        System.out.println(a);
        System.out.println(b);
        long result = dividep(a, b) * sign;
        System.out.println(result);
        return (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) result;
    }
    
    private long dividep(long dividend, long divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        long result = 0;
        while (dividend >= divisor) {
            int count = 0;
            long num = divisor;
            while ((num << 1) <= dividend) {
                num = num << 1;
                count += 1;
            }
            dividend -= num;
            result += 1 << count;
        }
        return result;
    }
}