public class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : 1.0 / pow(x, -n);
    }
    
    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double halfpow = pow(x, n / 2);
        if (n % 2 == 0) {
            return halfpow * halfpow;
        } else {
            return halfpow * halfpow * x;
        }
    }
}