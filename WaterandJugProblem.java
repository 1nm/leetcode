public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || z == x || z == y || z == x + y || z == Math.abs(x - y)) return true;
        if (z > x + y) return false;
        int d = gcd(gcd(x, y), z);
        x /= d; y /= d; z /= d;
        if (gcd(x, y) == 1) return true;
        return false;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}