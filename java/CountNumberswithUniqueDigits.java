public class Solution {
    long max;
    public int countNumbersWithUniqueDigits(int n) {
        max = (long) Math.pow(10, n);
        return backtrack(0, 0);
    }
    
    int backtrack(long num, int mask) {
        int count = 0;
        for (int digit = 0; digit < 10; ++ digit) {
            if (num == 0 && digit == 0) {
                count ++;
                continue;
            }
            int bit = (1 << digit);
            boolean used = (mask & bit) != 0;
            if (!used && num * 10 + digit < max) {
                count ++;
                mask ^= bit;
                count += backtrack(num * 10 + digit, mask);
                mask ^= bit;
            }
        }
        return count;
    }
}