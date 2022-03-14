// binary search between 0 and Math.sqrt(Integer.MAX_VALUE)
public class Solution {
    private static final int MAX_SQRT = (int) Math.sqrt(Integer.MAX_VALUE);
    public int mySqrt(int x) {
        int start = 0, end = x < MAX_SQRT ? x : MAX_SQRT;
        while (start < end) {
            int mid = start + ((end - start + 1) >> 1);
            int mul = mid * mid;
            if (mul == x) {
                return mid;
            } else if (mul > x) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return end;
    }
}
