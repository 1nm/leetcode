public class Solution {
    public int findNthDigit(int n) {
        int digits = 1;
        long limit = 9;
        while (n > digits * limit) {
            n -= digits * limit;
            limit *= 10;
            digits ++;
        }
        int num = (int) Math.pow(10, digits - 1) + (n - 1) / digits;
        return nth(num, (n - 1) % digits);
    }

    private int nth(int num, int n) {
        return String.valueOf(num).charAt(n) - '0';
    }
}
