public class Solution {
    public boolean isPerfectSquare(int num) {
        int a = isqrt(num);
        return a * a == num;
    }
    private int isqrt(int num) {
        // find x that meets x^2 - n = 0
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (int) x;
    }
}