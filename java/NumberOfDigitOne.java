public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        long[] ones = new long[20];
        int x = 1;
        long pow = 1;
        while (pow <= Integer.MAX_VALUE) {
            ones[x] = ones[x - 1] * 10 + pow;
            pow *= 10;
            x ++;
        }
        String str = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < str.length(); ++ i) {
            int digit = str.charAt(i) - '0';
            int s = str.length() - 1 - i;
            n %= (int) Math.pow(10, s);
            if (digit > 1) {
                count += digit * ones[s] + (int) Math.pow(10, s);
            } else if (digit == 1) {
                count += n + ones[s] + 1;
            }
        }
        return count;
    }
}