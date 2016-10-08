public class Solution {
    public int superPow(int a, int[] b) {
        if (a < 2) return a;
        int result = 1;
        int apow = a;
        for (int i = b.length - 1; i >= 0; -- i) {
            result = result * moduloPow(apow, b[i], 1337) % 1337;
            apow = moduloPow(apow, 10, 1337);
        }
        return result;
    }

    private int moduloPow(int a, int b, int m) {
        if (b == 0)
            return 1;
        else {
            int c = moduloPow(a, b / 2, m);
            if ((b & 1) == 0)
                return (int) ((long) c * c % 1337);
            else
                return (int) ((long) a * c * c % 1337);
        }
    }
}